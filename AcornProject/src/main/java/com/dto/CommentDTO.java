package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Comment")
public class CommentDTO {
	private int num;
	private int comment_boardnum;
	private String comment_author;
	private String comment_content;
	private String writeday;
	private int repStep;
	private int repIndent;
	private int repRoot;
	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentDTO(int num, int comment_boardnum, String comment_author, String comment_content, String writeday,
			int repStep, int repIndent, int repRoot) {
		super();
		this.num = num;
		this.comment_boardnum = comment_boardnum;
		this.comment_author = comment_author;
		this.comment_content = comment_content;
		this.writeday = writeday;
		this.repStep = repStep;
		this.repIndent = repIndent;
		this.repRoot = repRoot;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getComment_boardnum() {
		return comment_boardnum;
	}
	public void setComment_boardnum(int comment_boardnum) {
		this.comment_boardnum = comment_boardnum;
	}
	public String getComment_author() {
		return comment_author;
	}
	public void setComment_author(String comment_author) {
		this.comment_author = comment_author;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public int getRepStep() {
		return repStep;
	}
	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}
	public int getRepIndent() {
		return repIndent;
	}
	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}
	public int getRepRoot() {
		return repRoot;
	}
	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}
	@Override
	public String toString() {
		return "CommentDTO [num=" + num + ", comment_boardnum=" + comment_boardnum + ", comment_author="
				+ comment_author + ", comment_content=" + comment_content + ", writeday=" + writeday + ", repStep="
				+ repStep + ", repIndent=" + repIndent + ", repRoot=" + repRoot + "]";
	}
	
}
