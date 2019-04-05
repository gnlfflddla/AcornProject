package com.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ProductDTO {

	private String pCode;
	private String pName;
	private String pContent;
	private String pCategory; 
	private ArrayList<String> pColor;
	private ArrayList<String> pSize;
	private int pPrice;
	private String pImage;
	private List<MultipartFile> files;
	
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String pCode, String pName, String pContent, String pCategory, ArrayList<String> pColor,
			ArrayList<String> pSize, int pPrice, String pImage, List<MultipartFile> files) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pContent = pContent;
		this.pCategory = pCategory;
		this.pColor = pColor;
		this.pSize = pSize;
		this.pPrice = pPrice;
		this.pImage = pImage;
		this.files = files;
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

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public ArrayList<String> getpColor() {
		return pColor;
	}

	public void setpColor(ArrayList<String> pColor) {
		this.pColor = pColor;
	}

	public ArrayList<String> getpSize() {
		return pSize;
	}

	public void setpSize(ArrayList<String> pSize) {
		this.pSize = pSize;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "ProductDTO [pCode=" + pCode + ", pName=" + pName + ", pContent=" + pContent + ", pCategory=" + pCategory
				+ ", pColor=" + pColor + ", pSize=" + pSize + ", pPrice=" + pPrice + ", pImage=" + pImage + ", files="
				+ files + "]";
	}
	
	
	
	
	
}
