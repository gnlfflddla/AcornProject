package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Comment")
public class CommentDTO {
	private int num;
	private int rootnum;
	private String author;
	private String content;
	private String writeday;
	private int repStep;
	private int repIndent;
	private int repRoot;
	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentDTO(int num, int rootnum, String author, String content, String writeday, int repStep, int repIndent,
			int repRoot) {
		super();
		this.num = num;
		this.rootnum = rootnum;
		this.author = author;
		this.content = content;
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
	public int getRootnum() {
		return rootnum;
	}
	public void setRootnum(int rootnum) {
		this.rootnum = rootnum;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
		return "CommentDTO [num=" + num + ", rootnum=" + rootnum + ", author=" + author + ", content=" + content
				+ ", writeday=" + writeday + ", repStep=" + repStep + ", repIndent=" + repIndent + ", repRoot="
				+ repRoot + "]";
	}
	
}
