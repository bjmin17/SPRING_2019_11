package com.biz.rbook.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biz.rbook.domain.ReadBookVO;

// 필수가 아닌 권장사항, 다오를 매퍼로 해달라
@Mapper
public interface ReadBookDao {

	@Select("SELECT * FROM tbl_read_book")
	public List<ReadBookVO> selectAll();

}
