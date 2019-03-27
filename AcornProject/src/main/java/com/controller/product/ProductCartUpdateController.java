package com.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@Controller
public class ProductCartUpdateController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("ProductCartUpdate")
	public @ResponseBody String ProductCartUpdate(ProductCartDTO dto) {
		
		int result = service.ProductCartUpdate(dto);
		
		return "success";
	}
}
