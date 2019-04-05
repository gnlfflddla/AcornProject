package com.dto;

public class MailDTO {

	private String title;
	private String gradenoS;
	private String gradenoA;
	private String gradenoB;
	private String gradenoC;
	private String gradenoD;
	private String contents;
	public MailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MailDTO(String title, String gradenoS, String gradenoA, String gradenoB, String gradenoC, String gradenoD,
			String contents) {
		super();
		this.title = title;
		this.gradenoS = gradenoS;
		this.gradenoA = gradenoA;
		this.gradenoB = gradenoB;
		this.gradenoC = gradenoC;
		this.gradenoD = gradenoD;
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "MailDTO [title=" + title + ", gradenoS=" + gradenoS + ", gradenoA=" + gradenoA + ", gradenoB="
				+ gradenoB + ", gradenoC=" + gradenoC + ", gradenoD=" + gradenoD + ", contents=" + contents + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGradenoS() {
		return gradenoS;
	}
	public void setGradenoS(String gradenoS) {
		this.gradenoS = gradenoS;
	}
	public String getGradenoA() {
		return gradenoA;
	}
	public void setGradenoA(String gradenoA) {
		this.gradenoA = gradenoA;
	}
	public String getGradenoB() {
		return gradenoB;
	}
	public void setGradenoB(String gradenoB) {
		this.gradenoB = gradenoB;
	}
	public String getGradenoC() {
		return gradenoC;
	}
	public void setGradenoC(String gradenoC) {
		this.gradenoC = gradenoC;
	}
	public String getGradenoD() {
		return gradenoD;
	}
	public void setGradenoD(String gradenoD) {
		this.gradenoD = gradenoD;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
	
	
	