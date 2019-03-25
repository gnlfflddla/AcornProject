package com.dto;

public class MemberDTO {
	private String userid;
	private String passwd;
	private String username;
	private String birthday;
	private String addr;
	private String phone;
	private String email;
	private String gradeno;
	private String reception;
	
	public MemberDTO() {}
	
	public MemberDTO(String userid, String passwd, String username, String birthday, String addr, String phone,
			String email, String gradeno, String reception) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.birthday = birthday;
		this.addr = addr;
		this.phone = phone;
		this.email = email;
		this.gradeno = gradeno;
		this.reception = reception;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGradeno() {
		return gradeno;
	}
	public void setGradeno(String gradeno) {
		this.gradeno = gradeno;
	}
	public String getReception() {
		return reception;
	}
	public void setReception(String reception) {
		this.reception = reception;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", birthday="
				+ birthday + ", addr=" + addr + ", phone=" + phone + ", email=" + email + ", gradeno=" + gradeno
				+ ", reception=" + reception + "]";
	}

	
	
	
}