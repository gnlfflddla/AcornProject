package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ProductCartDTO;
import com.dto.ProductOrderDTO;

@Repository
public class ProductCartDAO {

	@Autowired
	SqlSessionTemplate session;
	
	// 장바구니 상품 등록
	public int ProductCartAdd(ProductCartDTO dto) {
		int result = session.insert("ProductCartMapper.ProductCartAdd",dto);
		return result;
	}
	
	// 장바구니 목록
	public List<ProductCartDTO> ProductCartList(){
		List<ProductCartDTO> list = session.selectList("ProductCartMapper.ProductCartList");
		return list;
	}
	
	// 장바구니 상품 삭제
	public int ProductCartDel(int num) {
		int result = session.delete("ProductCartMapper.ProductCartDel",num);
		return result;
	}
	
	// 장바구니 수량 수정
	public int ProductCartUpdate(ProductCartDTO dto) {
		int result = session.update("ProductCartMapper.ProductCartUpdate",dto);
		return result;
	}
	
	// 장바구니 다중선택 삭제
	public int ProductCartAllDel(List<String> list) {
		int result = session.delete("ProductCartMapper.ProductCartAllDel",list);
		return result;
	}
	
	// 상품 구매 .. 장바구니 목록
	public List<ProductCartDTO> ProductCartOrderList(int num){
		List<ProductCartDTO> list = session.selectList("ProductCartMapper.ProductCartOrderList",num);
		return list;
	}
	
	// 상품 구매
	public int ProductOrderDone(ProductOrderDTO dto) {
		int n = session.insert("ProductCartMapper.ProductOrderDone",dto);
		return n;
	}
	
	// 상품 전체 구매 .. 목록
	public List<ProductCartDTO> ProductCartOrderAllList(List<String>data){
		List<ProductCartDTO> list = session.selectList("ProductCartMapper.ProductCartOrderAllList",data);
		return list;
	}
	
	// 상품 전체 구매
	public int ProductOrderAllDone(List<ProductOrderDTO> x) {
		int n = session.insert("ProductCartMapper.ProductOrderAllDone",x);
		return n;
	}
	
	// seqnum 가져오기
	public int Seqnum() {
		int n = session.selectOne("ProductCartMapper.seqnum");
		return n;
	}
}
