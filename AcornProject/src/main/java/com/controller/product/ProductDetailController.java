package com.controller.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.ProductDTO;
import com.service.ProductService;

@Controller
public class ProductDetailController {

	@Autowired
	ProductService service;
	
	@RequestMapping("productDetail")
	public String ProductDetail(@RequestParam("pCode") String pCode, Model m) {
		
		ProductDTO dto = service.ProductDetailList(pCode);
		List<String> pColorList = service.pColorList(pCode);
		List<String> pSizeList = service.pSizeList(pCode);		
		int result = service.OrderQuantity(pCode);
		
		m.addAttribute("ProductDetail", dto);
		m.addAttribute("pColorList", pColorList);
		m.addAttribute("pSizeList", pSizeList);
		m.addAttribute("OrderQuantity", result);
		
		return "productDetail";
	}
}
