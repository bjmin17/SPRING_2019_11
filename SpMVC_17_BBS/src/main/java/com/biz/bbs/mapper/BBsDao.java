package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.BBsVO;

public interface BBsDao {

	@Select("SELECT * FROM tbl_bbs ORDER BY bbs_date DESC, bbs_time DESC")
	public List<BBsVO> selectAll();
}
