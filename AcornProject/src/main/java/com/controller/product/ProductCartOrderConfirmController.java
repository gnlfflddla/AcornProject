package com.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@Controller
public class ProductCartOrderConfirmController {

	@Autowired
	ProductCartService service;

	@RequestMapping("ProductCartOrderConfirm")
	public String ProductCartOrderConfirm(@RequestParam("num") int num, Model m) {
		
		List<ProductCartDTO> list = service.ProductCartOrderList(num);
		m.addAttribute("orderList", list);
		
		return "productOrderConfirm";
	}
}
