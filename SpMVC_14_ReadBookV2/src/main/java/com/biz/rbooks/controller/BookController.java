package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/book")
@Controller
public class BookController {

	private final BookService bService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String list(Model model) {
		List<BookVO> bookList = bService.selectAll();
		
		model.addAttribute("BLIST",bookList);
		return "books/list";
	}
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public String search(@RequestParam(value="strText",required = false,defaultValue = "") String strText, Model model) {
	
		List<BookVO> bookList = bService.findByBNames(strText);
		
		model.addAttribute("BLIST",bookList);
		return "books/list-body";
	}
	
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String insert(BookVO bookVO) {
		
		// 비어있는 BookVO를 만들어서 insert에 주입
//		bService.insert(new BookVO());
		bService.insert(bookVO);
		
		return "redirect:/book/list";
	}
	
}
