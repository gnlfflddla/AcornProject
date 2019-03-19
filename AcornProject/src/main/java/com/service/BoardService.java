package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.dto.CommentDTO;
import com.dto.CommentPageDTO;
import com.dto.BoardPageDTO;
@Service
public class BoardService {
	@Autowired
	BoardDAO dao;
	public BoardDTO boardRetrieve(String _num) {
		BoardDTO dto = new BoardDTO();
		dto = dao.boardRetrieve(_num);
		return dto;
	}
	public BoardDTO boardReplyUI(String _num) {
		BoardDTO dto = new BoardDTO();
		dto = dao.boardReplyUI(_num);
		return dto;
	}
	public BoardPageDTO boardList(BoardPageDTO pDTO) {
			pDTO = dao.boardList(pDTO);
		return pDTO;
	}
	public int boardWrite(BoardDTO dto) {
		int result=0;
			result = dao.boardWrite(dto);
		return result;
	}
	public int boardUpdate(BoardDTO dto) {
		int result=0;
			result = dao.boardUpdate(dto);
		return result;
	}
	public int boardDelete(String _num) {
		int result=0;
			result = dao.boardDelete(_num);
		return result;
	}
	public BoardPageDTO boardSearch(BoardDTO dto, BoardPageDTO pDTO) {
			pDTO = dao.boardSearch(dto,pDTO);
		return pDTO;
	}
	public void boardReply(BoardDTO dto) {
			dao.boardReply(dto);
	}
	//comment 
	public void cmtWrite(CommentDTO cdto) {
			dao.cmtWrite(cdto);
	}
	public void cmtReply(CommentDTO cdto) {
			dao.cmtReply(cdto);
	}
	public CommentPageDTO cmtList(CommentPageDTO cmtPDTO,String num) {
			cmtPDTO = dao.cmtList(cmtPDTO,num);
		return cmtPDTO;
	}

}
