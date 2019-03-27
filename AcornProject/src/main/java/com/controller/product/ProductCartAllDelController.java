package com.controller.product;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.ProductCartService;


@Controller
public class ProductCartAllDelController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("ProductCartAllDel")
	public String ProductCartAllDel(@RequestParam("check") String[] check) {
		
		List<String> list = Arrays.asList(check);
		int result = service.ProductCartAllDel(list);
		
		return "redirect:ProductCartList";
	}
	
}
