package com.biz.rbook.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.rbook.domain.BookVO;

public interface BookDao {

	@Select("SELECT * FROM tbl_books")
	public List<BookVO> selectAll();
	
}
