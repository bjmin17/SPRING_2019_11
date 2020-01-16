package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.ReadBookVO;

public interface ReadBookDao {

	public List<ReadBookVO> selectAll();
	/*
	 * 도서코드로 조회하기
	 */
	
	public ReadBookVO findBySeq(long rb_seq);
	public List<ReadBookVO> findByBCode(String rb_code);
	public int insert(ReadBookVO rBookVO);
}
