package com.controller.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.dto.CommentPageDTO;
import com.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService bservice;

	@RequestMapping("/boardList")
	public String boardList(@RequestParam(value="curPage",required=false,defaultValue="1") String curPage,Model model) {
		BoardPageDTO pDTO = new BoardPageDTO();
		pDTO.setCurPage(Integer.parseInt(curPage));
		pDTO = bservice.boardList(pDTO);
		model.addAttribute("boardList", pDTO);
		return "boardForm";
	}
	@RequestMapping("/search")
	public String boardSearch(String searchName,String searchValue,@RequestParam(value="curPage",required=false, defaultValue="1")String curPage,HttpSession session,Model model) {
		if(searchName!=null) {
			session.setAttribute("searchName", searchName);
			session.setAttribute("searchValue", searchValue);
		}
		
		BoardPageDTO pDTO = new BoardPageDTO();
		pDTO.setCurPage(Integer.parseInt(curPage));
		BoardDTO dto = new BoardDTO();
		if(session.getAttribute("searchName").equals("title")) {
			dto.setTitle((String)session.getAttribute("searchValue"));
			
		}else if(session.getAttribute("searchName").equals("author")) {
			dto.setAuthor((String)session.getAttribute("searchValue"));
		}
		pDTO = bservice.boardSearch(dto,pDTO);
		model.addAttribute("boardList", pDTO);
		return "boardForm";
	}
	@RequestMapping("/retrieve")
	public String boardRetrieve(String num,@RequestParam(value="curPage",required=false,defaultValue="1") String curPage,HttpSession session,Model model) {
		if(num==null) {
			num = (String)session.getAttribute("num");
		}
		BoardDTO dto = bservice.boardRetrieve(num);
		model.addAttribute("retrieve", dto);
		
		//comment
		CommentPageDTO cmtPDTO = new CommentPageDTO();
		cmtPDTO.setCurPage(Integer.parseInt(curPage));
		cmtPDTO = bservice.cmtList(cmtPDTO, num);
		return "boardRetrieveForm";
	}
	
	@RequestMapping("/delete")
	public String boardDelete(@RequestParam("num") String num,Model model) {
		int n=bservice.boardDelete(num);
		if(n==1) {
			model.addAttribute("mesg", "게시글이 삭제되었습니다.");
		}else {
			model.addAttribute("mesg", "게시글 삭제가 실패되었습니다.");
		}
		return "redirect:/boardList";
	}
	
	@RequestMapping("/replyui")
	public String boardReplyUI(@RequestParam("num") String num,Model model) {
		BoardDTO dto = bservice.boardReplyUI(num);
		model.addAttribute("replyui", dto);
		return "../board/boardReply";
	}
	@RequestMapping("/reply")
	public String boardReply(BoardDTO dto) {
		bservice.boardReply(dto);
		return "redirect:/boardList";
	}
	
	@RequestMapping("write")
	public String boardWrite(BoardDTO dto) {
		return "";
	}
	
}
