package com.biz.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.domain.HobbyDTO;
import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.UserService;

@RequestMapping(value="/user")
@Controller
public class UserController {

	/*
	 * UserService 인터페이스로 uService 객체를 선언하고
	 * UserServiceImp 클래스로 초기화 생성을 수행
	 */
	@Autowired
	UserService uService;
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		
		// UserDTO userDTO = new UserDTO();
		UserDTO userDTO = UserDTO.builder().build();
		
		// 취미리스트
		List<HobbyDTO> hList = uService.getHobbyList();
		
		// 취미리스트를 hList로 담았음
		model.addAttribute("HO_LIST",hList);
		
		// strH 문자열 배열을 만들어서 취미리스트의 0번째 있는 코드 값을 뽑아서 배열로 만들고
		/*
		String[] strH = new String[]{
				hList.get(0).getH_code(),
				hList.get(3).getH_code()
		};
		// 이를 U_hobby에 담았음
		userDTO.setU_hobby(strH);
		*/
		
		
		// 모델에 담았음
		model.addAttribute("userDTO", userDTO);
		
		return "user/insert";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserDTO userDTO, Model model) {
		
		int ret = uService.userJoin(userDTO);
		return "redirect:/memo/list";
		
	}
}
