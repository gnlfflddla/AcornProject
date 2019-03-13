package com.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.dto.CommentPageDTO;
import com.dto.BoardPageDTO;
import com.service.BoardService;

public class BoardRetrieveCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String num=request.getParameter("num");
		if(num==null) {
			HttpSession session = request.getSession();
			num = (String)session.getAttribute("num");
		}
		BoardDTO dto = new BoardDTO();
		BoardService service = new BoardService();
		dto=service.boardRetrieve(num);
		
		request.setAttribute("retrieve", dto);
		//comment
		String curPage="1";
		CommentPageDTO cmtPDTO = new CommentPageDTO();
		if(request.getParameter("curPage")!=null) {
			curPage = request.getParameter("curPage");
		}
		cmtPDTO.setCurPage(Integer.parseInt(curPage));
		cmtPDTO = service.cmtList(cmtPDTO, num);
		request.setAttribute("cmtPDTO", cmtPDTO);
	}

}
