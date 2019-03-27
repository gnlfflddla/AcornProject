package com.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.ProductOrderDTO;
import com.service.ProductCartService;

@Controller
public class ProductCartOrderDoneController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("/ProductCartOrderDone")
	public String ProductCartOrderDone(ProductOrderDTO dto, Model m) {
		
		String userid = "admin";
		dto.setUserid(userid);
		
		int num = dto.getNum();
		int n = service.ProductOrderDone(dto,num);
		
		m.addAttribute("ProductOrderDTO", dto);
		
		return "productOrderDone";
	}
}
