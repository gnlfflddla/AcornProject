package com.dto;

public class MemberDTO {
	private String userid;
	private String passwd;
	private String username;
	private String birthday;
	private String post;
	private String addr1;
	private String addr2;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email1;
	private String email2;
	private String gradeno;
	private String reception;
	private int mileage;
	
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MemberDTO(String userid, String passwd, String username, String birthday, String post, String addr1,
			String addr2, String phone1, String phone2, String phone3, String email1, String email2, String gradeno,
			String reception, int mileage) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.birthday = birthday;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.gradeno = gradeno;
		this.reception = reception;
		this.mileage = mileage;
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


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getAddr1() {
		return addr1;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public String getAddr2() {
		return addr2;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getPhone1() {
		return phone1;
	}


	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}


	public String getPhone2() {
		return phone2;
	}


	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


	public String getPhone3() {
		return phone3;
	}


	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}


	public String getEmail1() {
		return email1;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
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


	public int getMileage() {
		return mileage;
	}


	public void setMileage(int mileage) {
		this.mileage = mileage;
	}


	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", birthday="
				+ birthday + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", phone3=" + phone3 + ", email1=" + email1 + ", email2=" + email2
				+ ", gradeno=" + gradeno + ", reception=" + reception + ", mileage=" + mileage + "]";
	}
}