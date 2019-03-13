package com.command;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.service.BoardService;

public class BoardSearchCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String searchName=request.getParameter("searchName");
		String searchValue=request.getParameter("searchValue");
		HttpSession session = request.getSession();
		if(searchName!=null) {
			session.setAttribute("searchName", searchName);
			session.setAttribute("searchValue", searchValue);
		}
		String curPage="1";
		if(request.getParameter("curPage") != null) {
			curPage=request.getParameter("curPage");
		}
		BoardPageDTO pDTO = new BoardPageDTO();
		pDTO.setCurPage(Integer.parseInt(curPage));
		BoardDTO dto = new BoardDTO();
		if(session.getAttribute("searchName").equals("title")) {
			dto.setTitle((String)session.getAttribute("searchValue"));
			
		}else if(session.getAttribute("searchName").equals("author")) {
			dto.setAuthor((String)session.getAttribute("searchValue"));
		}
		BoardService service = new BoardService();
		pDTO = service.boardSearch(dto,pDTO);
		request.setAttribute("pList", pDTO);
		request.setAttribute("pkind", "search.do");
	}

}
