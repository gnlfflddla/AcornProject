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
public class MemberController {
	@Autowired
	MemberService mservice;
	
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map,HttpSession session) {
		String nextPage=null;
		MemberDTO dto = new MemberDTO();
		dto=mservice.login(map);
		if(dto!=null) {
			session.setAttribute("login", dto);
			nextPage="main";
		}else {
			nextPage="redirect:/loginUI";
		}
		return nextPage;
	}
	
}
