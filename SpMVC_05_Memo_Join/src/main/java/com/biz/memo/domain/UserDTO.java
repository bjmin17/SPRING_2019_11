package com.biz.memo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

	private String u_id;
	private String u_password;
	private String u_name;
	private String u_nick;
	public String u_grade;
	public String u_tel;
	
	// 사용자의 취미를 
	// 여러가지 중복 선택할 수 있도록 기능
	// 기능을 구현하기 위해 배열로 선언
	// checkbox와 연결되는 변수, 대응하는 변수
	private String[] u_hobby;
	
    
}
