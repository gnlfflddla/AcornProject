package com.dto;

public class ProductCartDTO {

	private int num;
	private String userid;
	private String pCode;
	private String pName;
	private int pPrice;
	private String pSize;
	private int pAmount;
	private String pImage;
	private String pColor;
	
	public ProductCartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductCartDTO(int num, String userid, String pCode, String pName, int pPrice, String pSize, int pAmount,
			String pImage, String pColor) {
		super();
		this.num = num;
		this.userid = userid;
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pSize = pSize;
		this.pAmount = pAmount;
		this.pImage = pImage;
		this.pColor = pColor;
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
	public String getpColor() {
		return pColor;
	}
	public void setpColor(String pColor) {
		this.pColor = pColor;
	}
	
	@Override
	public String toString() {
		return "ProductCartDTO [num=" + num + ", userid=" + userid + ", pCode=" + pCode + ", pName=" + pName
				+ ", pPrice=" + pPrice + ", pSize=" + pSize + ", pAmount=" + pAmount + ", pImage=" + pImage
				+ ", pColor=" + pColor + "]";
	}
	
	
	
}
