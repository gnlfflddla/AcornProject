package com.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.ProductDTO;
import com.service.ProductService;

@Controller
public class ProductAddController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value="/productAdd", method=RequestMethod.POST)
	public String ProductAdd(ProductDTO dto){
		CommonsMultipartFile theFile = dto.getTheFile();
		String originalName = theFile.getOriginalFilename();
		
		dto.setpImage(originalName);
		
		// originalName 을 c://upload 디렉토리에 저장
		File f = new File("c://upload",originalName);
		try {
			theFile.transferTo(f); // 이전 방식의 .write()
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int n= service.ProductAdd(dto);
		
		return "redirect:/";
	}
	
	
}
