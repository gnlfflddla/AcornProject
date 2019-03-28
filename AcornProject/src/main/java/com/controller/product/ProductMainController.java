package com.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.ProductCartDTO;
import com.dto.ProductDTO;
import com.dto.ProductOrderDTO;
import com.service.ProductCartService;
import com.service.ProductService;

@Controller
public class ProductMainController {

	@Autowired
	ProductService Pservice;
	
	@Autowired
	ProductCartService Cservice;
	
	// 상품 메인화면 
	@RequestMapping("/")
	public String ProductList(Model m){
		
		List<ProductDTO> list = Pservice.ProductList();
		List<ProductDTO> list2 = Pservice.ProductinfoList();
		
		m.addAttribute("productList", list);
		m.addAttribute("productinfoList", list2);
		
		return "productMain";
	}
	
	//상품 등록 
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
		int n= Pservice.ProductAdd(dto);
		return "redirect:/";
	}
	
	//상품 상세보기
	@RequestMapping("productDetail")
	public String ProductDetail(@RequestParam("pCode") String pCode, Model m) {
		
		ProductDTO dto = Pservice.ProductDetailList(pCode);
		List<String> pColorList = Pservice.pColorList(pCode);
		List<String> pSizeList = Pservice.pSizeList(pCode);		
		int result = Pservice.OrderQuantity(pCode);
		
		m.addAttribute("ProductDetail", dto);
		m.addAttribute("pColorList", pColorList);
		m.addAttribute("pSizeList", pSizeList);
		m.addAttribute("OrderQuantity", result);
		
		return "productDetail";
	}
	
	// 장바구니 등록
	@RequestMapping("ProductCartAdd")
	public String ProductCartAdd(ProductCartDTO dto) {
		
		String userid = "admin";
		dto.setUserid(userid);
		
		int result = Cservice.ProductCartAdd(dto);
		
		return "redirect:/"; // main화면
	}
	
	// 바로구매
	@RequestMapping("ProductBuyInstantController")
	public String ProductBuyInstantController(ProductCartDTO dto, Model m) {
		
		String userid = "admin";
		
		int num = Cservice.Seqnum();
		dto.setNum(num);
		m.addAttribute("buyinstant", dto);
		
		return "productBuyInstant";
	}
	
	// 장바구니 목록
	@RequestMapping("ProductCartList")
	public String ProductCartList(Model m) {
		
		List<ProductCartDTO> list = Cservice.ProductCartList();
		m.addAttribute("ProductCartList", list);
		
		return "productCartList";
	}
	
	// 장바구니 수정
	@RequestMapping("ProductCartUpdate")
	public @ResponseBody String ProductCartUpdate(ProductCartDTO dto) {
		
		int result = Cservice.ProductCartUpdate(dto);
		
		return "success";
	}
	
	// 장바구니 삭제
	@RequestMapping("ProductCartDel")
	public String ProductCartDel(@RequestParam("num") int num) {
		int result = Cservice.ProductCartDel(num);
		
		return "redirect:ProductCartList";
	}
	
	// 장바구니 선택(전체)삭제
	@RequestMapping("ProductCartAllDel")
	public String ProductCartAllDel(@RequestParam("check") String[] check) {
		
		List<String> list = Arrays.asList(check);
		int result = Cservice.ProductCartAllDel(list);
		
		return "redirect:ProductCartList";
	}
	
	// 장바구니 상품 구매
	@RequestMapping("/ProductCartOrderDone")
	public String ProductCartOrderDone(ProductOrderDTO dto, Model m) {
		
		String userid = "admin";
		dto.setUserid(userid);
		
		int num = dto.getNum();
		int n = Cservice.ProductOrderDone(dto,num);
		
		m.addAttribute("ProductOrderDTO", dto);
		
		return "productOrderDone";
	}
	
	// 장바구니 상품 구매 완료
	@RequestMapping("ProductCartOrderConfirm")
	public String ProductCartOrderConfirm(@RequestParam("num") int num, Model m) {
		
		List<ProductCartDTO> list = Cservice.ProductCartOrderList(num);
		m.addAttribute("orderList", list);
		
		return "productOrderConfirm";
	}
	
	// 장바구니 상품 선택(전체) 구매
	@RequestMapping("ProductCartOrderAllDoneController")
	public String ProductCartOrderAllDoneController(@RequestParam("num") String nums[],
			ProductOrderDTO dto, Model m) {
		
		String userid = "admin";
		
		List<String> list = Arrays.asList(nums);
		List<ProductCartDTO> cList = Cservice.ProductCartOrderAllList(list);
		
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
		
		int n = Cservice.ProductOrderAllDone(oList, list);
		m.addAttribute("orderAllDone", oList);
		
		return "productOrderAllDone";
	}
	
	// 장바구니 상품 선택(전체) 구매 완료
	@RequestMapping("ProductCartOrderAllConfirmController")
	public String ProductCartOrderAllConfirmController(@RequestParam("check") String[] check, Model m) {
		
		List<String> list = Arrays.asList(check);
		List<ProductCartDTO> cList = Cservice.ProductCartOrderAllList(list);
		m.addAttribute("cartList", cList);
		
		return "productOrderAllConfirm";
	}
}
