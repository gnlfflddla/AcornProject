package com.controller.product;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@Controller
public class ProductCartOrderAllConfirmController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("ProductCartOrderAllConfirmController")
	public String ProductCartOrderAllConfirmController(@RequestParam("check") String[] check, Model m) {
		
		List<String> list = Arrays.asList(check);
		List<ProductCartDTO> cList = service.ProductCartOrderAllList(list);
		m.addAttribute("cartList", cList);
		
		return "productOrderAllConfirm";
	}
}
