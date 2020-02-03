package com.biz.bbs.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {

	private String menu_id;
	private String menu_p_id;
	private String menu_title;
	private String menu_href;
	
	// 자기 자신을 또 하나의 리스트로 받는 클래스
	/*
	 * drop down을 구현하기 위해서 자기 자신을 List로 설정
	 */
	List<MenuVO> drop_menus;

}
