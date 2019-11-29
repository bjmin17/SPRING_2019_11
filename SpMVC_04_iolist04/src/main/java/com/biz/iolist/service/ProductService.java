package com.biz.iolist.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.ProductDTO;
import com.biz.iolist.persistence.ProductDao;

@Service
public class ProductService {

	@Autowired
	SqlSession sqlSession;
	
	ProductDao pDao;
	
	@Autowired
	public void getProMapper() {
		pDao = sqlSession.getMapper(ProductDao.class);
	}
	
	public List<ProductDTO> getAllList(){
		
//		ProductDao proDao = sqlSession.getMapper(ProductDao.class);
		
		List<ProductDTO> proList = pDao.selectAll();
		return proList;
	}

	public ProductDTO findByPCode(String p_code) {
		
//		ProductDao proDao = sqlSession.getMapper(ProductDao.class);
		ProductDTO pDTO = pDao.findByPCode(p_code);
		return pDTO;
		
	}

	public int insert(ProductDTO proDTO) {

//		ProductDao proDao = sqlSession.getMapper(ProductDao.class);
		
		String p_code = pDao.getPCode();
		
		String p_code_num = p_code.substring(1);
		
		int int_pcode = Integer.valueOf(p_code_num)+1;
		
		p_code = p_code.substring(0,1);
		p_code += String.format("%04d", int_pcode);
		
		proDTO.setP_code(p_code);
		
		int ret = pDao.insert(proDTO);
		
		return ret;
	}
	
	public int delete(String p_code) {
//		ProductDao proDao = sqlSession.getMapper(ProductDao.class);
		int ret = pDao.delete(p_code);
		return ret;
	}
	public int update(ProductDTO proDTO) {
//		ProductDao proDao = sqlSession.getMapper(ProductDao.class);
		int ret = pDao.update(proDTO);
		return ret;
	}

	public List<ProductDTO> selectNameSearch(String strText) {

		List<ProductDTO> proList = null;
		/*
		 * 입력박스에 상품코드가 입력된 상태에서 Enter를 누르면
		 * 상품코드로 상품을 조회하고
		 * 그렇지 않으면 이름으로 조회하라
		 */
		
		// 상품코드로 상품조회 해오기
		ProductDTO pDTO = pDao.findByPCode(strText);
		
		// 상품코드에 해당하는 제품정보가 조회되면
		if(pDTO != null) {
			// 그 상품만 리스트에 별도로 담아서 Controller로 보내기
			proList = new ArrayList<ProductDTO>();
			proList.add(pDTO);
		} else {
			// 그렇지 않으면 이름으로 조회하기
			proList = pDao.findByName(strText);
		}
//		proList = pDao.findByName(strText);
		return proList;
	}
}
