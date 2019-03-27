package com.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.ProductCartService;


@Controller
public class ProductCartDelController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("ProductCartDel")
	public String ProductCartDel(@RequestParam("num") int num) {
		int result = service.ProductCartDel(num);
		
		return "redirect:ProductCartList";
	}
}
