package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDAO;
import com.dto.ProductDTO;

@Service
public class ProductService {
	
	@Autowired
	ProductDAO dao;
	
	// 상품등록
	public int ProductAdd(ProductDTO dto) {
		int n=0;
		n = dao.ProductAdd(dto);
		return n;
	}
	
	// 상품 목록
	public List<ProductDTO> ProductList(){
		List<ProductDTO> list = null;
			list = dao.ProductList();
		return list;
	}
	
	// 상품 색상, 사이즈 목록
	public List<ProductDTO> ProductinfoList(){
		List<ProductDTO> list2 = null;
			list2 = dao.ProductinfoList();
		return list2;
	}
	
	// 상품 상세 목록
	public ProductDTO ProductDetailList(String pCode){
		ProductDTO list = null;
			list = dao.ProductDetailList(pCode);
		return list;
	}
	
	// 상품 색상 목록
	public List<String> pColorList(String pCode) {
		List<String> pColorList = null;
			pColorList = dao.pColorList(pCode);
		return pColorList;
	}
	
	// 상품 사이즈 목록
	public List<String> pSizeList(String pCode) {
		List<String> pSizeList = null;
			pSizeList = dao.pSizeList(pCode);
		return pSizeList;
	}
	
	// 상품 구매 횟수 
	public int OrderQuantity(String pCode) {
		int result=0;
			result = dao.OrderQuantity(pCode);
		return result;
	}

	public List<ProductDTO> productCategoryList(String gCategory) {
		List<ProductDTO> list = null;
			list = dao.productCategoryList(gCategory);
		return list;
	}

	

}
