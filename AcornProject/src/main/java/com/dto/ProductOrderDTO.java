package com.dto;

public class ProductOrderDTO {

	private int num;
	private String userid;
	private String pCode;
	private String pName;
	private int pPrice;
	private String pSize;
	private String pColor;
	private int pAmount;
	private String pImage;
	private String orderName;
	private String post;
	private String addr1;
	private String addr2;
	private String phone;
	private String payMethod;
	private String orderday;
	
	public ProductOrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductOrderDTO(int num, String userid, String pCode, String pName, int pPrice, String pSize, String pColor,
			int pAmount, String pImage, String orderName, String post, String addr1, String addr2, String phone,
			String payMethod, String orderday) {
		super();
		this.num = num;
		this.userid = userid;
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pSize = pSize;
		this.pColor = pColor;
		this.pAmount = pAmount;
		this.pImage = pImage;
		this.orderName = orderName;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.payMethod = payMethod;
		this.orderday = orderday;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public int getpAmount() {
		return pAmount;
	}

	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getOrderday() {
		return orderday;
	}

	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}

	@Override
	public String toString() {
		return "ProductOrderDTO [num=" + num + ", userid=" + userid + ", pCode=" + pCode + ", pName=" + pName
				+ ", pPrice=" + pPrice + ", pSize=" + pSize + ", pColor=" + pColor + ", pAmount=" + pAmount
				+ ", pImage=" + pImage + ", orderName=" + orderName + ", post=" + post + ", addr1=" + addr1 + ", addr2="
				+ addr2 + ", phone=" + phone + ", payMethod=" + payMethod + ", orderday=" + orderday + "]";
	}
	

	
	
	
}
