package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDAO;
import com.dto.ProductDTO;
import com.dto.ProductOrderDTO;

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
	
	// 상품 카테고리 목록 
	public List<ProductDTO> ProductCategoryList(String pcategory){
		List<ProductDTO> list = null;
			list = dao.ProductCategoryList(pcategory);
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
	
	// 상품구매 목록
	public List<ProductOrderDTO> ProductOrderList(String userid) {
		List<ProductOrderDTO> list = dao.ProductOrderList(userid);
		return list;
	}
	
	// 구매상품 삭제
	public int ProductOrderDel(int num) {
		int result = 0;
			result = dao.ProductOrderDel(num);
		return result;
	}
	
	// 구매상품 선택 삭제
	public int ProductOrderAllDel(List<String> list){
		int result = 0;
			result = dao.ProductOrderAllDel(list);
		return result;
	}
	
	// 상품구매 상세 목록
	public List<ProductOrderDTO> ProductOrderDetail(int num) {
		List<ProductOrderDTO> list = dao.ProductOrderDetail(num);
		return list;
	}
	
	// 상품 검색
	public List<ProductDTO> ProductSearch(String pSearch) {
		List<ProductDTO> list = dao.ProductSearch(pSearch);
		return list;
	}
	

}
