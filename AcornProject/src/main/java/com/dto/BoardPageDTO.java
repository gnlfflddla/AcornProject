package com.dto;

import java.util.List;

public class BoardPageDTO {

	private List<BoardDTO> list;
	private int curPage;
	private int perPage = 10;
	private int totalCount;
	private int totalPage;

	public BoardPageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardPageDTO(List<BoardDTO> list, int curPage, int perPage, int totalCount, int totalPage) {
		super();
		this.list = list;
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}
	public void totalPageResult() {
		totalPage = totalCount/perPage;
		if(totalCount%perPage !=0 ) totalPage++;
		if(totalPage==0) totalPage=1;
	}
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
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
		totalPageResult();
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		return "PageDTO [list=" + list + ", curPage=" + curPage + ", perPage=" + perPage + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + "]";
	}

	
	
	
	
	
	
	
	
	
}
