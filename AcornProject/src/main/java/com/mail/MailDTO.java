package com.mail;

public class MailDTO {

	private  String mailTo;
	private String from="acorn1324@naver.com";
	private  String subject="acorn 쇼핑몰 인증번호 발송";
	private  String text;
	public MailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MailDTO(String mailTo, String from, String subject, String text) {
		super();
		this.mailTo = mailTo;
		this.from = from;
		this.subject = subject;
		this.text = text;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "MailDTO [mailTo=" + mailTo + ", from=" + from + ", subject=" + subject + ", text=" + text + "]";
	}
}
