package com.biz.ems.config;

public class Naver {
	public static class TOKEN {
		public final static String grant_type = "grant_type";	//	string	y	-	인증 과정에 대한 구분값
									//1) 발급:'authorization_code'
									//2) 갱신:'refresh_token'
									//3) 삭제: 'delete'
		public final static String client_id = "client_id";	//	string	y	-	애플리케이션 등록 시 발급받은 client id 값
		public final static String client_secret = "client_secret";//	string	y	-	애플리케이션 등록 시 발급받은 client secret 값
		public final static String code = "code";		//	string	발급 때 필수	-	로그인 인증 요청 api 호출에 성공하고 리턴받은 인증코드값 (authorization code)
		public final static String state = "state";		//	string	발급 때 필수	-	사이트 간 요청 위조(cross-site request forgery) 공격을 방지하기 위해 애플리케이션에서 생성한 상태 토큰값으로 url 인코딩을 적용한 값을 사용
		public final static String refresh_token = "refresh_token";//	string	갱신 때 필수	-	네이버 사용자 인증에 성공하고 발급받은 갱신 토큰(refresh token)
		public final static String access_token = "access_token";//	string	삭제 때 필수	-	기 발급받은 접근 토큰으로 url 인코딩을 적용한 값을 사용
		public final static String service_provider = "service_provider";//	string	삭제 때 필수	'naver'	인증 제공자 이름으로 'naver'로 세팅해 전송
	}
	
	public static class GRANT_TYPE {
		
		public final static String authorization_code = "authorization_code"; // 발급
		public final static String refresh_token = "refresh_token"; // 갱신
		public final static String delete = "delete"; // 삭제
		
	}
	
}
