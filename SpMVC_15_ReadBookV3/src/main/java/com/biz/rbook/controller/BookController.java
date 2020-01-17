package com.biz.rbook.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.rbook.domain.BookVO;
import com.biz.rbook.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/book")
@RequiredArgsConstructor
public class BookController {

	private final BookService bService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<BookVO> list() {
		
		return bService.selectAll();
		
	}
}
