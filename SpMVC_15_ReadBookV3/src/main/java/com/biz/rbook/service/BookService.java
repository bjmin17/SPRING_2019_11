package com.biz.rbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbook.domain.BookVO;
import com.biz.rbook.repository.BookDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

	private final BookDao bDao;
	
	public List<BookVO> selectAll() {

		return bDao.selectAll();
	}

	
	
	
}
