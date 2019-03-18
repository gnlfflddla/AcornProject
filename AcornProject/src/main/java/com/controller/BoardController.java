package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/boardList")
	@ModelAttribute("boardList")
	public String boardList(Model model) {
		
		return "boardForm";
	}
	
}
