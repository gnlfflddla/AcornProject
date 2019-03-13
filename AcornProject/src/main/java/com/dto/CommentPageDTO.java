package com.dto;

import java.util.List;

public class CommentPageDTO {

	private List<CommentDTO> list;
	private int curPage;
	private int perPage = 5;
	private int totalCount;
	private int totalPage;

	public CommentPageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentPageDTO(List<CommentDTO> list, int curPage, int perPage, int totalCount, int totalPage) {
		super();
		this.list = list;
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}

	public List<CommentDTO> getList() {
		return list;
	}

	public void setList(List<CommentDTO> list) {
		this.list = list;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		totalPageResult();
	}
	public void totalPageResult() {
		totalPage = totalCount/perPage;
		if(totalCount%perPage !=0 ) totalPage++;
		if(totalPage==0) totalPage=1;
	}
	
	
	
}
