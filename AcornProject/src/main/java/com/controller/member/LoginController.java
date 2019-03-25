package com.controller.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map,
						HttpSession session) {
		
		MemberDTO dto=service.login(map);
		
		String nextPage=null;
		if(dto!=null) {
			session.setAttribute("login", dto);
			nextPage="/main";
		}else {
			session.setAttribute("mesg", "아이디 또는 비빌번호를 다시 확인하세요.");
			nextPage="redirect:/loginUI"; //절대경로
			
		}

		return nextPage;
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}

}
