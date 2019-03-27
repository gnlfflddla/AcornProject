package com.controller.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.ProductCartDTO;
import com.dto.ProductOrderDTO;
import com.service.ProductCartService;

@Controller
public class ProductCartOrderAllDoneController {

	@Autowired
	ProductCartService service;
	
	@RequestMapping("ProductCartOrderAllDoneController")
	public String ProductCartOrderAllDoneController(@RequestParam("num") String nums[],
			ProductOrderDTO dto, Model m) {
		
		String userid = "admin";
		
		List<String> list = Arrays.asList(nums);
		List<ProductCartDTO> cList = service.ProductCartOrderAllList(list);
		
		List<ProductOrderDTO> oList = new ArrayList<ProductOrderDTO>();
		
		for(ProductCartDTO cDTO : cList) {
			ProductOrderDTO oDTO = new ProductOrderDTO();
			oDTO.setUserid(userid);
			oDTO.setNum(cDTO.getNum());
			oDTO.setpCode(cDTO.getpCode());
			oDTO.setpName(cDTO.getpName());
			oDTO.setpPrice(cDTO.getpPrice());
			oDTO.setpAmount(cDTO.getpAmount());
			oDTO.setpSize(cDTO.getpSize());
			oDTO.setpImage(cDTO.getpImage());
			oDTO.setpColor(cDTO.getpColor());
			oDTO.setOrderName(dto.getOrderName());
			oDTO.setPost(dto.getPost());
			oDTO.setAddr1(dto.getAddr1());
			oDTO.setAddr2(dto.getAddr2());
			oDTO.setPhone(dto.getPhone());
			oDTO.setPayMethod(dto.getPayMethod());
			oList.add(oDTO);
		}
		
		int n = service.ProductOrderAllDone(oList, list);
		m.addAttribute("orderAllDone", oList);
		
		return "productOrderAllDone";
	}
}
