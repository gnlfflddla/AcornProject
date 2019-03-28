package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductCartDAO;
import com.dto.ProductCartDTO;
import com.dto.ProductOrderDTO;

@Service
public class ProductCartService {

	@Autowired
	ProductCartDAO dao;

	// 장바구니 상품등록
	public int ProductCartAdd(ProductCartDTO dto) {
		int result=0;
			result = dao.ProductCartAdd(dto);
		return result;
	}
	
	// 장바구니 목록
	public List<ProductCartDTO> ProductCartList(){
		List<ProductCartDTO> list = null;
			list = dao.ProductCartList();
		return list;
	}
	
	// 장바구니 상품 삭제
	public int ProductCartDel(int num) {
		int result = 0;
			result = dao.ProductCartDel(num);
		return result;
	}
	
	// 장바구니 수량 수정
	public int ProductCartUpdate(ProductCartDTO dto) {
		int result = 0;
			result = dao.ProductCartUpdate(dto);
		return result;
	}
	
	// 상품 선택 삭제
	public int ProductCartAllDel(List<String> list){
		int result = 0;
			result = dao.ProductCartAllDel(list);
		return result;
	}
	
	// 상품 구매 .. 장바구니 목록
	public List<ProductCartDTO> ProductCartOrderList(int num){
		List<ProductCartDTO> list = null;
			list = dao.ProductCartOrderList(num);
		return list;
	}
	
	// 상품 구매
	public int ProductOrderDone(ProductOrderDTO dto, int num){
		int n = 0;
			n = dao.ProductOrderDone(dto);
			n = dao.ProductCartDel(num);
		return n;
	}
	
	// 상품 전체 구매 .. 목록
	public List<ProductCartDTO> ProductCartOrderAllList(List<String> data){
		List<ProductCartDTO> list = null;
			list = dao.ProductCartOrderAllList(data);
		return list;
	}
	
	// 상품 전체 구매
	public int ProductOrderAllDone(List<ProductOrderDTO> x, List<String> nums){
		int n = 0;
			n = dao.ProductOrderAllDone(x);
			n = dao.ProductCartAllDel(nums);
		return n;
	}
	
	// seqnum 가져오기
	public int Seqnum() {
		int n = 0;
			n = dao.Seqnum();
		return n;
	}
	
}
