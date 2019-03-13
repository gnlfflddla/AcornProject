package com.dto;

public class ChoolCheckDTO {

	private String userid;
	private String timecheck;
	private String choolcheck;
	private int count;
	
	
	public ChoolCheckDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ChoolCheckDTO(String userid, String timecheck, String choolcheck, int count) {
		super();
		this.userid = userid;
		this.timecheck = timecheck;
		this.choolcheck = choolcheck;
		this.count = count;
	}


	@Override
	public String toString() {
		return "ChoolCheckDTO [userid=" + userid + ", timecheck=" + timecheck + ", choolcheck=" + choolcheck
				+ ", count=" + count + "]";
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getTimecheck() {
		return timecheck;
	}


	public void setTimecheck(String timecheck) {
		this.timecheck = timecheck;
	}


	public String getChoolcheck() {
		return choolcheck;
	}


	public void setChoolcheck(String choolcheck) {
		this.choolcheck = choolcheck;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	
	
}
