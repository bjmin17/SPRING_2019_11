package com.biz.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NaverTokenVO {

	
	// 네이버로부터 발급받은 token
	private String access_token;//	string	삭제 때 필수	-	기 발급받은 접근 토큰으로 url 인코딩을 적용한 값을 사용
	
	// (선택) 네이버에 token을 재발급 요청했을 때 받은 token
	private String refresh_token;//	string	갱신 때 필수	-	네이버 사용자 인증에 성공하고 발급받은 갱신 토큰(refresh token)
	
	// (선택) 오류가 발생했을 때..
	private String error;
	private String error_description;

	private String token_type;
	
	// 유효기간
	private int expires_in;
	
	
//	private String code;		//	string	발급 때 필수	-	로그인 인증 요청 api 호출에 성공하고 리턴받은 인증코드값 (authorization code)
//	private String state;		//	string	발급 때 필수	-	사이트 간 요청 위조(cross-site request forgery) 공격을 방지하기 위해 애플리케이션에서 생성한 상태 토큰값으로 url 인코딩을 적용한 값을 사용
//	private String service_provider;//	string	삭제 때 필수	'naver'	인증 제공자 이름으로 'naver'로 세팅해 전송
}
