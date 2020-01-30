package com.biz.ems.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.SecureRandom;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.biz.ems.config.Naver;
import com.biz.ems.domain.NaverMember;
import com.biz.ems.domain.NaverMemberResponse;
import com.biz.ems.domain.NaverReturnAuth;
import com.biz.ems.domain.NaverTokenVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverLoginService {
	
	private final String clientId = "UmyU89drsEYRT3v4R6no";
	private final String clinetSec = "E5gLCh3aBm";
	
	private final String loginAPI_URL = "https://nid.naver.com/oauth2.0/authorize";
	private final String tokenAPI_URL = "https://nid.naver.com/oauth2.0/token";
	private final String naverMemberAPI_URL = "https://openapi.naver.com/v1/nid/me";
	
	
	
	private final String callbackLocalURL = "http://localhost:8080/ems/naver/ok";
	private final String callbackURL = "https://callor.com:12600/ems_bjmin17/member/naver/ok";
	
	public String oAuthLoginGet() {
		
			
		String redirectURI = null;
		
		try {
			redirectURI = URLEncoder.encode(callbackURL,"UTF-8");
			//"https://callor.com:12600/ems/naver/ok","UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SecureRandom random = new SecureRandom();
		
		// 최대값 130bit 크기 임의의 정수를 생성하여 문자열로 만들어라(아주 큰 정수 값)
		String stateKey =  new BigInteger(130,random).toString();
		log.debug("STATE KEY : " + stateKey);
		
		
		String apiURL = loginAPI_URL ;
		
		apiURL += "?client_id=" + this.clientId;
		apiURL += "&response_type=code";
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + stateKey;
		
		log.debug("URL : " + apiURL);
		
		
		return apiURL;
		
	}
	
	/**
	 * 
	 * 네이버에 정보요구를 할 때 사용할 토큰을 요청
	 * ~~~/token 주소로 token을 요청할 때, GET/POST method를 사용할 수 있는데
	 * 
	 * 여기서는 POST를 사용해서 요청을 하겠다.
	 * 
	 * @param naverOK
	 */
	public NaverTokenVO oAuthAccessGetToken(NaverReturnAuth naverOK) {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("X-Naver-Client-Id", this.clientId);
		headers.set("X-Naver-Client-Secret", this.clinetSec);
		
		/*
		 * Map interface를 상속받아 작성된 spring framework 전용 Map 인터페이스
		 * Http protocol과 관련된 곳에서 기본 Map 대신 사용하는 클래스
		 * Http protocol과 관련된 내장 method가 포함되어 있다.
		 * 
		 * 선언은 MultiValueMap으로
		 * 생성은 LinkedMultiValueMap으로
		 */
		MultiValueMap<String, String> params 
			= new LinkedMultiValueMap<String, String>();
		
		params.add(Naver.TOKEN.grant_type, Naver.GRANT_TYPE.authorization_code);
		params.add(Naver.TOKEN.client_id, this.clientId);
		params.add(Naver.TOKEN.client_secret, this.clinetSec);
		params.add(Naver.TOKEN.code, naverOK.getCode());
		params.add(Naver.TOKEN.state, naverOK.getState());
		
//		params.add("redirect_uri", redirectURL);
		
		// headers 담긴 정보와
		// params에 담긴 정보를
		// HttpEntity 데이터로 변환
		HttpEntity<MultiValueMap<String, String>> request 
			= new HttpEntity<MultiValueMap<String,String>>(params,headers);
		
		// URI 전송을 위해서 URI 만들기
		URI restURI = null;
		
		try {
			restURI = new URI(tokenAPI_URL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * RestTemplate를 사용하여 네이버에 token을 요청
		 */
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<NaverTokenVO> result = null;
		
		// request와 NaverTokenVO.class를 참고해서 데이터를 받아라
		result = restTemp.exchange(restURI, HttpMethod.POST,request,NaverTokenVO.class);
		
		log.debug("NAVER TOKEN : " + result.getBody().toString());
		
		return result.getBody();
		
	}
	
	
	
	public NaverMember getNaverMemberInfo(NaverTokenVO tokenVO) {
		
		String token = tokenVO.getAccess_token();
		String header = "bearer " + token;
		
		// header 문자열을 GET의 http header에 실어서
		// GET 방식으로 요청을 한다.
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", header);		
		
		HttpEntity<String> request = new HttpEntity<String>("parameter",headers);
		
		ResponseEntity<NaverMemberResponse> result;
		RestTemplate restTemp = new RestTemplate();
		
		result = restTemp.exchange(naverMemberAPI_URL, HttpMethod.GET, request,
								NaverMemberResponse.class);
		
		NaverMember member = result.getBody().response;
		
		return member;
		
		
		
	}
	
}
