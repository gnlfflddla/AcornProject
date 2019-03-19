package com.dao;

import java.util.ArrayList;


import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.BoardDTO;
import com.dto.CommentDTO;
import com.dto.CommentPageDTO;
import com.dto.BoardPageDTO;
@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate template;
	// 글자세히 보기
	public BoardDTO boardRetrieve(String num) {
		// TODO Auto-generated method stub
		BoardDTO dto = new BoardDTO();
		dto = template.selectOne("BoardMapper.boardRetrieve", num);
		readCount(num);
		return dto;
	}

	// 조회수 1증가
	public void readCount(String num) {
		template.update("BoardMapper.boardCnt", num);
	}

	// 페이징 전체, 검색조건에 따른 총 숫자 확인
	public int totalCount(BoardDTO dto) {
		return template.selectOne("BoardMapper.TotalCount", dto);
	}
	
	public int totalAllCount() {
		return template.selectOne("BoardMapper.TotalAllCount");
	}

	// 목록 보기
	public BoardPageDTO boardList(BoardPageDTO pDTO) {
		// TODO Auto-generated method stub
		
		int offset = (pDTO.getCurPage() - 1) * pDTO.getPerPage();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = template.selectList("BoardMapper.boardlist", null, new RowBounds(offset, pDTO.getPerPage()));
		pDTO.setList(list);
		pDTO.setTotalCount(totalAllCount());
		return pDTO;
	}

	// 글쓰기
	public int boardWrite(BoardDTO dto) {
		// TODO Auto-generated method stub
		int result = template.insert("BoardMapper.boardWrite", dto);

		return result;
	}

	// 글 수정하기
	public int boardUpdate(BoardDTO dto) {
		// TODO Auto-generated method stub
		int result = template.update("BoardMapper.boardUpdate", dto);

		return result;
	}

	// 글 수정하기
	public int boardDelete(String _num) {
		// TODO Auto-generated method stub
		int result = template.delete("BoardMapper.boardDelete", _num);

		return result;
	}

	// 글 검색하기
	public BoardPageDTO boardSearch(BoardDTO dto, BoardPageDTO pDTO) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		int offset = (pDTO.getCurPage() - 1) * pDTO.getPerPage();
		list = template.selectList("BoardMapper.boardSearch", dto, new RowBounds(offset, pDTO.getPerPage()));
		pDTO.setList(list);
		pDTO.setTotalCount(totalCount(dto));
		
		return pDTO;
	}

	// 답변글 입력폼 보기
	public BoardDTO boardReplyUI(String _num) {
		BoardDTO dto = new BoardDTO();
		dto = template.selectOne("BoardMapper.boardReplyUI", _num);
		return dto;
	}

	// 답변글 의 기존 repStep 1증가
	public void makeReply(BoardDTO dto) {
		template.update("BoardMapper.makeReply", dto);
	}

	// 답변달기
	public void boardReply(BoardDTO dto) {
		makeReply(dto);
		template.insert("BoardMapper.boardReply", dto);
	}
	// 페이징 전체, 검색조건에 따른 총 숫자 확인 댓글 ver
		public int totalCmtCount(String num) {
			return template.selectOne("CommentMapper.TotalCmtCount",num);
		}

	//댓글 입력
	public void cmtWrite(CommentDTO cdto) {
		// TODO Auto-generated method stub
		template.insert("CommentMapper.cmtWrite", cdto);
	}
	//댓글목록
	public CommentPageDTO cmtList(CommentPageDTO cmtPDTO,String num) {
		// TODO Auto-generated method stub
		int offset = (cmtPDTO.getCurPage() - 1) * cmtPDTO.getPerPage();
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		list = template.selectList("CommentMapper.cmtlist", num, new RowBounds(offset, cmtPDTO.getPerPage()));
		cmtPDTO.setList(list);
		cmtPDTO.setTotalCount(totalCmtCount(num));
		return cmtPDTO;
	}

	public void cmtReply(CommentDTO cdto) {
		// TODO Auto-generated method stub
		int repStep=makeCmtReply(cdto);
		System.out.println(repStep);
		
		cdto.setRepStep(repStep);
		template.insert("CommentMapper.cmtReply", cdto);
	}

	private int makeCmtReply(CommentDTO cdto) {
		// TODO Auto-generated method stub
		return template.selectOne("CommentMapper.makeCmtReply", cdto);
	}
}
