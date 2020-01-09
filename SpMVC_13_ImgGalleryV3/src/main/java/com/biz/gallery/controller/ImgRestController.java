package com.biz.gallery.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.domain.MemberVO;
import com.biz.gallery.repository.ImageDao;
import com.biz.gallery.repository.ImageFileDao;
import com.biz.gallery.service.FileService;
import com.biz.gallery.service.ImageFileService;
import com.biz.gallery.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/rest")
@RestController
public class ImgRestController {

	private final FileService fService;
	private final ImageFileService ifService;
	private final MemberService mService;
	
	private final ImageDao imgDao;
	private final ImageFileDao ifDao;
	
	@Autowired
	public ImgRestController(FileService fService, ImageFileService ifService, ImageDao imgDao, 
			ImageFileDao ifDao, MemberService mService) {
		super();
		this.fService = fService;
		this.ifService = ifService;
		this.imgDao = imgDao;
		this.ifDao = ifDao;
		this.mService = mService;
	}

	@RequestMapping(value="/file_up", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	public String file_up(@RequestParam("file") MultipartFile upfile) {

		String upLoadFileName = fService.file_up(upfile);
		
		// 업로드가 잘못됐단 얘기
		if(upLoadFileName == null) return "FAIL";
		else return upLoadFileName;
		
	}
	
	/*
	 * fileDownload
	 * 1. 단순히 파일을 클릭했을 때, 링크를 주고 다운로드 받는 방법
	 * 		서버에 저장된 파일 이름으로 그대로 다운로드가 되고
	 * 		서버에 대한 정보가 노출되기 쉽다.
	 * 
	 * 2. response에 파일을 실어서 보내고 
	 * 		web client 입장에서는 Http 프로토콜의 body에 실려오는 
	 * 		데이터를	수신하는 형태
	 * 	서버에 저장된 파일이 노출되지 않더라도 파일을 다운로드 할 수 있다.
	 * 	이미지 이외의 파일일 경우 감춰진 폴더에 저장해두었다가
	 * 	별도의 다운로드 기능을 구현하여 다운 받을 수 있도록 하는 경우
	 * 	파일 종류에 관계없이 다운로드 가능
	 * 
	 */
	@RequestMapping(value="/file_down/{img_file_seq}",method=RequestMethod.GET)
	public String file_down(
			@PathVariable("img_file_seq") String img_file_seq,
			HttpServletRequest req,
			HttpServletResponse res) {
	// 파일을 res에 실어서 보낼것임
		// 1. img_file_seq 값으로 다운로드를 수행할 파일정보를 
		// 		DB로부터 추출
		ImageFilesVO imgFVO = ifDao.findBySeq(Long.valueOf(img_file_seq));
		
		// 2. 서버에 저장된 파일 이름(UUID+파일이름) 가져오기
		String downFileName = imgFVO.getImg_file_upload_name();
		
		// 3. 파일이름과 서버의 저장된 path 정보를 연결
		File downFile = fService.find_down(downFileName);
		// 다운파일이 없으면 못주겠다고 보냄
		if(downFile == null) return "NOT_FOUND";

		// 실제 업로드전 원래 이름으로 다운로드를 실행할 수 있도록 준비
		String originName = imgFVO.getImg_file_origin_name();
		if(originName == null || originName.equals("")) {
			originName = "noname.file";
		}
		
		// 지금 나에게 down을 요청한 브라우저가 누구냐?
		String browser = req.getHeader("User-Agent");
		

			
			// 대한+민국 같은 
			// 단어 중간의 +를 공백으로 바꾸기
			try {
				if(browser.contains("MSIE") || 
						browser.contains("Chrome") ||
						browser.contains("Trident")) {
						originName = URLEncoder.encode(originName,"UTF-8").replaceAll("\\+", "%20");
				} else {
					// 위에 나열한 브라우저가 아니면 인코딩을 String 방식으로 처리
					originName = new String(originName.getBytes("UTF-8"),"ISO-8850-1");
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				log.debug("파일이름 인코딩 오류 발생");
			}
				
		
		// response에 파일을 싣기 위해서 설정을 한다.
		// octer-stream : 이름?을 한줄로 보냄 없음ㄴ 다운로드가 안됨
		res.setContentType("application/octer-stream");
		res.setHeader("Content-Transfer-Encoding", "binary");
		
		// 파일을 보낼 때 원래이름으로 보이도록 만드는 작업
		originName = String.format("attachment;filename=%s", originName);
		res.setHeader("Content-Disposition", originName);
		
		try {
			// 통로를 열어달라
			OutputStream os = res.getOutputStream();
			
			// 서버에 저장된 파일 읽어오기
			FileInputStream fs = new FileInputStream(downFile);
			
			int nCount = 0;
			byte[] sendData = new byte[512];
			
			while(true) {
				
				nCount = fs.read(sendData);
				if(nCount == -1) break;
				
				// 실려있는 데이터 중 0 부터 511까지의 데이터를 보낸다.
				// 마지막은 0부터 3(예를 들어, 511보다 작은 수) 까지를 보내면 알아서 잘 받아라
				os.write(sendData,0,nCount);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.debug("다운로드 중 오류 발생");
		}
	
		return "OK";
	}
	
	@RequestMapping(value="/image_delete",method=RequestMethod.POST)
	public String img_delete(@RequestParam("img_id") String img_id) {
		
		try {
			ImageFilesVO imgVO = ifService.findBySeq(img_id);
			fService.file_delete(imgVO.getImg_file_upload_name());
			ifService.img_file_delete(img_id);
		} catch (Exception e) {
			// TODO: handle exception
			return "FAIL";
		}
		return "OK";
	}
	
	@RequestMapping(value="/main_image",method=RequestMethod.POST)
	public String main_image(
					@RequestParam("img_pcode") String img_pcode,
					@RequestParam("img_file") String img_file
					) {
		ImageVO imageVO = imgDao.findBySeq(img_pcode);
		imageVO.setImg_file(img_file);
		
		int ret = imgDao.update(imageVO);
		
		return ret + "";
	}
	
	// ${rootPath}/rest/member/login
	@RequestMapping(value="/member/login",method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model, HttpSession httpSession) {

		memberVO = mService.loginCheck(memberVO);
		// 정상적인 사용자라면
		if(memberVO != null) {
			httpSession.setAttribute("MEMBER", memberVO);
			return "LOGIN_OK";
		} else {
			// 혹시 로그인에 실패하면 session을 빼줘야함
			httpSession.removeAttribute("MEMBER");
			return "LOGIN_FAIL";
		}

	}
	
	
}
