package com.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@Controller
public class ProductCartAddController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("ProductCartAdd")
	public String ProductCartAdd(ProductCartDTO dto) {
		
		String userid = "admin";
		dto.setUserid(userid);
		
		int result = service.ProductCartAdd(dto);
		
		return "redirect:/"; // main화면
	}
}
