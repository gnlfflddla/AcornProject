package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;



public class LoginServlet extends HttpServlet {
	
	int count=0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*request.setCharacterEncoding("UTF-8");*/
		
		String userid=request.getParameter("userid");
		String passwd=request.getParameter("passwd");
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd",passwd);
		
		
		MemberService service=new MemberService();
		MemberDTO dto=service.login(map);
			
		HttpSession session=request.getSession();
		
		String nextPage="";
		if(dto!=null) {
			nextPage="MainServlet";
			session.setAttribute("login", dto);
		}else {
			count++;
			
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "아이디 또는 비빌번호를 다시 확인하세요.");
			if(count==5) {
				nextPage="";
				System.out.println("본인인증");
			}
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
