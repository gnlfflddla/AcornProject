package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.dto.CommentDTO;
import com.service.BoardService;

public class CmtWriteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String rootnum=request.getParameter("comment_boardnum");
		String author=request.getParameter("comment_author");
		String content=request.getParameter("comment_content");
		CommentDTO cdto = new CommentDTO();
		cdto.setRootnum(Integer.parseInt(rootnum));
		cdto.setAuthor(author);
		cdto.setContent(content);
		BoardService service = new BoardService();
		service.cmtWrite(cdto);
		HttpSession session = request.getSession();
		session.setAttribute("num", rootnum);
		
	}

}
