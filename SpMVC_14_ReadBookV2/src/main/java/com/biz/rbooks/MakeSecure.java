package com.biz.rbooks;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.SaltGenerator;

public class MakeSecure {

	// 배포할때는 이와같이 변경하거나 감추기
	private final static String saltPass = "YOUR SALT";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		// 윈도우 운영체제 환경변수 가져오기
		Map<String,String> envList = System.getenv();
		
		System.out.print("UserID >> ");
		String pUserId = scanner.nextLine();
		
		System.out.print("Password >> ");
		String pPassword = scanner.nextLine();
		
		// 운영체제 환경변수 중 ORACLE_PASS로 등록된 값 가져오기
		String envString = envList.get("ORACLE_PASS");
		
		if(envString == null) envString = saltPass;
		
		// 암호화를 MD5와 DES로 하겠다
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(envString);
		
		String encUserId = pbEnc.encrypt(pUserId);
		String encPassword = pbEnc.encrypt(pPassword);
		
		System.out.printf("userid : %s, %s\n", pUserId, encUserId);
		System.out.printf("password : %s, %s\n", pPassword, encPassword);
		
		String strUserId 
			= String.format("oracle.username=ENC(%s)", encUserId);
		String strPassword 
			= String.format("oracle.password=ENC(%s)", encPassword);
		
		String proFileName = "./src/main/webapp/WEB-INF/spring/oracle.sec.properties";
		try {
			PrintWriter out = new PrintWriter(proFileName);
			out.println(strUserId);
			out.println(strPassword);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
		
	}
}
