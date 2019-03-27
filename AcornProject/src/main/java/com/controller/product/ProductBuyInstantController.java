package com.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@Controller
public class ProductBuyInstantController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("ProductBuyInstantController")
	public String ProductBuyInstantController(ProductCartDTO dto, Model m) {
		
		String userid = "admin";
		
		int num = service.Seqnum();
		dto.setNum(num);
		m.addAttribute("buyinstant", dto);
		
		return "productBuyInstant";
	}
}
