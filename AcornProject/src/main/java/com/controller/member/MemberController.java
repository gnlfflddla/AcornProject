package com.controller.member;

import java.net.Authenticator;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping("/agreement")
	public String agreement(@RequestParam("reception") String reception,HttpSession session) {
	
		session.setAttribute("reception", reception);
		
		return "redirect:/memberUI";
	}
	
	@RequestMapping("/memberAdd")
	public String memberAdd(MemberDTO dto,HttpSession session) {
		System.out.println(dto);
		int n=service.memberAdd(dto);
		if(n!=0) {
			session.setAttribute("mesg", "회원가입 성공");
		}
		return "redirect:/main";
	}
	
	@RequestMapping("/memberIdCheck")
	public @ResponseBody int memberIdCheck(@RequestBody Map<String, String> map ) {

		String userid=map.get("userid");
		int count =service.idCheck(userid);
		
		return count;
	}
	
	@RequestMapping("/myPage")
	public String myPage(HttpSession session) {
		
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		System.out.println(dto);
		return "myPageForm" ;
	}
	
	@RequestMapping("/withdrawal")
	public String withdrawal(@RequestParam String passwd, HttpSession session) {
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		
		String userid=dto.getUserid();
		
		Map<String, String> map=new HashMap();
		map.put("userid",userid);
		map.put("passwd",passwd);
		
		int n=service.withdrawal(map);
		
		String nextPage="";
		
		if(n==1) {
			nextPage="memberoutForm";
			session.invalidate();
		}else {
			nextPage="WithdrawalUI";
			session.setAttribute("mesg", "비밀번호를 확인해주세요.");
		}
		
		return nextPage ;
	}
	
	@RequestMapping("/memberUpdate")
	public String memberUpdate(MemberDTO dto2, HttpSession session) {
		
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		System.out.println(dto);
		String nextPage="";
		if(dto!=null) {
			System.out.println(dto2);
			
			int n=service.update(dto2);
			nextPage="main";
			session.setAttribute("login", dto2);
			session.setAttribute("mesg", "수정이 완료되었습니다.");
		}else {
			nextPage="loginUI";
		}
		
		
		return nextPage;
	}
	
	

}
