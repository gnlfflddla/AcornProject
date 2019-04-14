package com.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.ProductDTO;
import com.service.ProductService;


@Controller
public class MainController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping("/main")
	public String main(Model m) {
		List<ProductDTO> list = service.ProductList();
		m.addAttribute("productList", list);
		return "main";
	}

}
