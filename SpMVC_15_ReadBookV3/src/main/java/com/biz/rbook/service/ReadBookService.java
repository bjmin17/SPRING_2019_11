package com.biz.rbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbook.domain.ReadBookVO;
import com.biz.rbook.repository.ReadBookDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReadBookService {

	private final ReadBookDao rbDao;
	
	public List<ReadBookVO> selectAll() {
		List<ReadBookVO> rBookList = rbDao.selectAll();
		return rBookList;
		
	}

	
}
