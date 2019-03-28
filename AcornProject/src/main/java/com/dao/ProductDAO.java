package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ProductDTO;
import com.dto.ProductInfoDTO;

@Repository
public class ProductDAO {

	@Autowired
	SqlSessionTemplate session;

	// 상품 등록
	public int ProductAdd(ProductDTO dto) {
		int n = 0;
		n = session.insert("ProductMapper.ProductAdd", dto);
		for (int i = 0; i < dto.getpColor().size(); i++) {
			for (int j = 0; j < dto.getpSize().size(); j++) {
				ProductInfoDTO pdto = new ProductInfoDTO();
				pdto.setpCode(dto.getpCode());
				pdto.setpColor(dto.getpColor().get(i));
				pdto.setpSize(dto.getpSize().get(j));
				n = session.insert("ProductMapper.ProductAdd2", pdto);
			}
		}
		return n;
	}

	// 상품 목록
	public List<ProductDTO> ProductList() {
		List<ProductDTO> list = session.selectList("ProductMapper.ProductList");
		return list;
	}

	// 상품 색상,사이즈 목록
	public List<ProductDTO> ProductinfoList() {
		List<ProductDTO> list2 = session.selectList("ProductMapper.ProductinfoList");
		return list2;
	}

	// 상품 상세 목록 .. Product
	public ProductDTO ProductDetailList(String pCode) {
		ProductDTO list = session.selectOne("ProductMapper.ProductDetailList", pCode);
		return list;
	}

	// 상품 색상 목록
	public List<String> pColorList(String pCode) {
		List<String> pColorList = session.selectList("ProductMapper.pColorList", pCode);
		return pColorList;
	}

	// 상품 사이즈 목록
	public List<String> pSizeList(String pCode) {
		List<String> pSizeList = session.selectList("ProductMapper.pSizeList", pCode);
		return pSizeList;
	}

	// 상품 구매 횟수
	public int OrderQuantity(String pCode) {
		int result = session.selectOne("ProductMapper.OrderQuantity", pCode);
		return result;
	}

	public List<ProductDTO> productCategoryList(String gCategory) {
		// TODO Auto-generated method stub
		List<ProductDTO> list = session.selectList("ProductMapper.productCategoryList", gCategory);
		return list;
	}

}
