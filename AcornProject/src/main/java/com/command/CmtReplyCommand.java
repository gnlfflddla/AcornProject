package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.dto.CommentDTO;
import com.service.BoardService;

public class CmtReplyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String rootnum=request.getParameter("rootnum");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		String repRoot = request.getParameter("repRoot");
		CommentDTO cdto = new CommentDTO();
		cdto.setRootnum(Integer.parseInt(rootnum));
		cdto.setAuthor(author);
		cdto.setContent(content);
		cdto.setRepRoot(Integer.parseInt(repRoot));
		BoardService service = new BoardService();
		service.cmtReply(cdto);
		HttpSession session = request.getSession();
		session.setAttribute("num", rootnum);
		
	}

}
