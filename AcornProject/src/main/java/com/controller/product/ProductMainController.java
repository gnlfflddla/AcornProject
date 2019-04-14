package com.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.MemberDTO;
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
	

	MemberDTO mDTO = new MemberDTO();
	
	//상품 카테고리 목록 
	@RequestMapping("ProductCategoryList")
	@CrossOrigin
	public String ProductCategoryList(@RequestParam("pcategory") String pcategory, Model m) {
		if(pcategory==null)pcategory="top";
		
		List<ProductDTO> list = Pservice.ProductCategoryList(pcategory);
		m.addAttribute("productList", list);
		
		return "main";
	}
	
	//상품 등록 
	@RequestMapping(value="productAdd", method=RequestMethod.POST)
	public String ProductAdd(ProductDTO dto, HttpSession session){
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			List<MultipartFile> files = dto.getFiles();
			
			List<String> fileNames = new ArrayList<String>();
			
			if (null != files && files.size() > 0) {
				for (MultipartFile multipartFile : files) {
					String fileName = multipartFile.getOriginalFilename();
					fileNames.add(fileName);
					
					File f = new File("c://upload",fileName);

					try {
						multipartFile.transferTo(f);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// 이미지를 , 로 구분해서 문자열 저장
				String pImage2 = "";
				for(int i=0; i<fileNames.size(); i++) {
					if(i!=0&&i<fileNames.size()) {
						pImage2+=",";
					}
					pImage2 += fileNames.get(i);
				}
				dto.setpImage(pImage2);
			}
			
			int n= Pservice.ProductAdd(dto);
			nextPage="redirect:/main";		
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");
		}
		return nextPage;
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
	public String ProductCartAdd(ProductCartDTO dto, HttpSession session) {
		 	
		 mDTO = (MemberDTO)session.getAttribute("login");
		 String nextPage=null;
		 
		 if(mDTO!=null) {
			 dto.setUserid(mDTO.getUserid());
			 int result = Cservice.ProductCartAdd(dto);
			 nextPage="redirect:/main";		 
		 }else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");			 
		 }
		return nextPage;
	}
	
	// 바로구매
	@RequestMapping("ProductBuyInstantController")
	public String ProductBuyInstantController(ProductCartDTO dto, Model m, HttpSession session) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {		
			int num = Cservice.Seqnum();
			dto.setNum(num);
			m.addAttribute("buyinstant", dto);
			nextPage="productBuyInstant";	
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");
		}
		
		return nextPage;
	}
	
	// 장바구니 목록
	@RequestMapping("ProductCartList")
	public String ProductCartList(Model m, HttpSession session) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			List<ProductCartDTO> list = Cservice.ProductCartList();
			m.addAttribute("ProductCartList", list);
			nextPage="productCartList";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");			
		}
		return nextPage;
	}
	
	// 장바구니 수정
	@RequestMapping("ProductCartUpdate")
	public @ResponseBody String ProductCartUpdate(ProductCartDTO dto, HttpSession session) {

		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			int result = Cservice.ProductCartUpdate(dto);
			nextPage="success";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");						
		}
		return nextPage;
	}
	
	// 장바구니 삭제
	@RequestMapping("ProductCartDel")
	public String ProductCartDel(@RequestParam("num") int num, HttpSession session) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			int result = Cservice.ProductCartDel(num);
			nextPage="redirect:ProductCartList";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");				
		}
		return nextPage;
	}
	
	// 장바구니 선택(전체)삭제
	@RequestMapping("ProductCartAllDel")
	public String ProductCartAllDel(@RequestParam("check") String[] check, HttpSession session) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			List<String> list = Arrays.asList(check);
			int result = Cservice.ProductCartAllDel(list);
			nextPage="redirect:ProductCartList";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");				
		}
		return nextPage;
	}
	
	// 장바구니 상품 구매
	@RequestMapping("/ProductCartOrderDone")
	public String ProductCartOrderDone(ProductOrderDTO dto, Model m, HttpSession session) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			dto.setUserid(mDTO.getUserid());
		
			int num = dto.getNum();
			int n = Cservice.ProductOrderDone(dto,num);
			m.addAttribute("ProductOrderDTO", dto);
			nextPage="productOrderDone";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");				
		}
		return nextPage;
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
			ProductOrderDTO dto, Model m, HttpSession session) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			List<String> list = Arrays.asList(nums);
			List<ProductCartDTO> cList = Cservice.ProductCartOrderAllList(list);
	
			List<ProductOrderDTO> oList = new ArrayList<ProductOrderDTO>();
		
			for(ProductCartDTO cDTO : cList) {
				ProductOrderDTO oDTO = new ProductOrderDTO();
				oDTO.setUserid(mDTO.getUserid());
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
				oDTO.setPhone1(dto.getPhone1());
				oDTO.setPhone2(dto.getPhone2());
				oDTO.setPhone3(dto.getPhone3());
				oDTO.setPayMethod(dto.getPayMethod());
				oList.add(oDTO);
			}
		
			int n = Cservice.ProductOrderAllDone(oList, list);
			m.addAttribute("orderAllDone", oList);
			nextPage="productOrderAllDone";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");				
		}
		return nextPage;
	}
	
	// 장바구니 상품 선택(전체) 구매 완료
	@RequestMapping("ProductCartOrderAllConfirmController")
	public String ProductCartOrderAllConfirmController(@RequestParam("check") String[] check, Model m) {
		
		List<String> list = Arrays.asList(check);
		List<ProductCartDTO> cList = Cservice.ProductCartOrderAllList(list);
		m.addAttribute("cartList", cList);
		
		return "productOrderAllConfirm";
	}
	
	// 구매상품 목록
	@RequestMapping("ProductOrderList")
	public String ProductOrderList(HttpSession session, Model m) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			String userid = mDTO.getUserid();
			List<ProductOrderDTO> list = Pservice.ProductOrderList(userid);
			m.addAttribute("OrderList", list);
			nextPage="productOrderList";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");				
		}
		return nextPage;
	}
	
	// 구매상품 삭제
	@RequestMapping("ProductOrderDel")
	public String ProductOrderDel(@RequestParam("num") int num, HttpSession session) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			int result = Pservice.ProductOrderDel(num);
			nextPage="redirect:ProductOrderList";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");				
		}
		return nextPage;
	}
	
	// 구매상품 선택(전체)삭제
	@RequestMapping("ProductOrderAllDel")
	public String ProductOrderAllDel(@RequestParam("check") String[] check, HttpSession session) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			List<String> list = Arrays.asList(check);
			int result = Pservice.ProductOrderAllDel(list);
			nextPage="redirect:ProductOrderList";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");				
		}
		return nextPage;
	}
	
	// 구매상품 상세목록
	@RequestMapping("ProductOrderDetail")
	public String ProductOrderDetail(HttpSession session, Model m, @RequestParam("num") int num) {
		
		mDTO = (MemberDTO)session.getAttribute("login");
		String nextPage=null;
		
		if(mDTO!=null) {
			List<ProductOrderDTO> list = Pservice.ProductOrderDetail(num);
			m.addAttribute("OrderDetail", list);
			nextPage="productOrderDetail";
		}else {
			nextPage="loginForm";
			session.setAttribute("loginMesg", "로그인 작업이 필요합니다.");				
		}
		return nextPage;
	}
	
	// 상품 검색 
	@RequestMapping("ProductSearch")
	public String ProductSearch(@RequestParam("pSearch") String pSearch, Model m, HttpSession session) {
		
		String nextPage=null;
		List<ProductDTO> list = Pservice.ProductSearch(pSearch);
		if(list.size()!=0) {
			m.addAttribute("productList", list);
			nextPage="main";
		}else {
			session.setAttribute("pSearch","검색 내용의 상품이 없습니다.");
			nextPage="redirect:/main";
		}
		return nextPage;
	}
	
	
}
