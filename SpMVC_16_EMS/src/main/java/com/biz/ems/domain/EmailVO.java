package com.biz.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmailVO {

	// 보내는 Email
	// 받는 Email
	// 보내는 사람 이름
	// 받는 사람 이름
	// 제목
	// 내용
	// 작성일자
	// 작성시각
	
	private String from_email;
	private String to_email;
	private String from_name;
	private String to_name;
	private String subject;
	private String content;
	private String send_date;
	private String send_time;
	
}
