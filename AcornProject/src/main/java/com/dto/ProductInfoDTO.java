package com.dto;

public class ProductInfoDTO {
	private String pCode;
	private String pColor;
	private String pSize;
	private int pStock;
	
	public ProductInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfoDTO(String pCode, String pColor, String pSize, int pStock) {
		super();
		this.pCode = pCode;
		this.pColor = pColor;
		this.pSize = pSize;
		this.pStock = pStock;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}

	@Override
	public String toString() {
		return "ProductInfoDTO [pCode=" + pCode + ", pColor=" + pColor + ", pSize=" + pSize + ", pStock=" + pStock
				+ "]";
	}
	

	
}
