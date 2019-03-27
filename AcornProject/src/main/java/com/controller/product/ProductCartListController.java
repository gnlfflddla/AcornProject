package com.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@Controller
public class ProductCartListController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("ProductCartList")
	public String ProductCartList(Model m) {
		
		List<ProductCartDTO> list = service.ProductCartList();
		m.addAttribute("ProductCartList", list);
		
		return "productCartList";
	}
}
