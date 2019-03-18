package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.BoardPageDTO;
import com.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService bservice;
	
	@RequestMapping("/boardList")
	@ModelAttribute("boardList")
	public String boardList(@RequestParam(value="curPage",required=false,defaultValue="1") String curPage,Model model) {
		BoardPageDTO pDTO = new BoardPageDTO();
		pDTO.setCurPage(Integer.parseInt(curPage));
		model.addAttribute("boardList", bservice.boardList(pDTO));
		return "boardForm";
	}
	
}
