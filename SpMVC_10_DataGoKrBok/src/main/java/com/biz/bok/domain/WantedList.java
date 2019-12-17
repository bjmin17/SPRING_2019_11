package com.biz.bok.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.ToString;

@XmlRootElement(name="wantedList")
@ToString
public class WantedList {
	
	public long numOfRows;		//	한페이지 결과수
	public long pageNum;		//	페이지번호
	public long totalCount;		//	전체 데이터수

	/*
	 * <watnedList>
	 * 		<servList></servList>
	 * 		<servList></servList>
	 * 		<servList></servList>
	 * 		<servList></servList>
	 * 		<servList></servList>
	 * </wantedList>
	 */
	
	public List<BokListVO> servList; 
}
