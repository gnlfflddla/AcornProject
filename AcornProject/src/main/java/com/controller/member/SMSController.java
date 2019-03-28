package com.controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.sms.SendSMS;

@Controller
public class SMSController {

	@Autowired
	MemberService service;

	@RequestMapping("/memberPW_phoneSearch")
	public String memberPW_phoneSearch(@RequestParam Map<String, String> map, HttpSession session) {

		String nextPage = "";
		int n = service.pwSearch_phone(map);

		if (n == 1) {
			char[] passwd2 = new char[10];

			for (int i = 0; i < 10; i++) {
				if (i % 2 == 0)
					passwd2[i] = (char) (48 + (int) (Math.random() * 10));
				else
					passwd2[i] = (char) (65 + (int) (Math.random() * 26));
			}

			String passwd = new String(passwd2);

			Map<String, String> map2 = new HashMap();
			map2.put("userid", map.get("userid"));
			map2.put("passwd", passwd);

			MemberService service2 = new MemberService();
			int n2 = service.passwdUpdate(map2);

			// 휴대폰으로 찾기
			SendSMS s = new SendSMS();
			String phone = map.get("phone1") + map.get("phone2") + map.get("phone3");
			s.sendsms(map2, phone);
			session.setAttribute("phone1", map.get("phone1"));
			session.setAttribute("phone2", map.get("phone2"));
			session.setAttribute("phone3", map.get("phone3"));
			nextPage = "sendSMSCompletedForm";

		} else {
			nextPage = "memberPWSearchUI";
			session.setAttribute("mesg", "입력하신 정보로 가입 된 회원 아이디는 존재하지 않습니다.");
		}
		return nextPage;

	}
}
