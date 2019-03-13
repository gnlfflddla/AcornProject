package com.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardPageDTO;
import com.service.BoardService;

public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardPageDTO pDTO = new BoardPageDTO();
		String curPage="1";
		if(request.getParameter("curPage") != null) {
			curPage=request.getParameter("curPage");
		}
		
		pDTO.setCurPage(Integer.parseInt(curPage));
		BoardService service = new BoardService();
		pDTO=service.boardList(pDTO);
		request.setAttribute("pList", pDTO);
		request.setAttribute("pkind", "list.do");
	}

}
