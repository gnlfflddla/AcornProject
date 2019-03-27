package com.controller.member;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.mail.MailDTO;
import com.service.MemberService;

@Controller
public class MailContoller {
	
	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	MemberService service;

	public String sendMail(final MailDTO dto) {

		final MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				String text = dto.getText();
				String mailTo = dto.getMailTo();

				helper.setFrom("swih0910@naver.com");
				helper.setTo(mailTo);
				helper.setSubject("acorn 쇼핑몰 인증번호 발송");
				helper.setText("인증번호:" + text, true);
			}
		};

		mailSender.send(preparator);

		return "ok";

	}


	@RequestMapping("/authenication_number")
	public @ResponseBody String authenication_number(@RequestBody final Map<String, String> map,HttpSession session) {

		char[] authenication_num2 = new char[10];
		for (int i = 0; i < 10; i++) {
			authenication_num2[i] = (char) (48 + (int) (Math.random() * 10));
		}

		String authenication_num = new String(authenication_num2);
		session.setAttribute("authenication_num",authenication_num);
		String mailTo = map.get("email");
		String text = "인증번호는 [" + authenication_num + "] 입니다.";

		MailDTO dto = new MailDTO();
		dto.setMailTo(mailTo);
		dto.setText(text);

		sendMail(dto);

		return "ok";
	}

	@RequestMapping("/certification")
	public ResponseEntity certification(@RequestBody final Map<String, String> map, HttpSession session) {

		String authenication_num = (String) session.getAttribute("authenication_num");
		String a_num = map.get("A_num");
		String mesg = "";

		if (a_num.trim().equals(authenication_num.trim()) == true) {

			mesg = "인증이완료되었습니다.";
		} else {
			mesg = "인증번호를 확인해주세요.";
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity(mesg, responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping("/memberIdSearch")
	public String memberIdSearch(MemberDTO dto, HttpSession session) {

		Map<String, String> map = service.idSearch(dto);

		String userid = map.get("USERID"); // 전체 아이디
		String userid1 = map.get("USERID1"); // 뒷자리 가린 아이디
		String username = dto.getUsername();
		String mailTo = dto.getEmail();
		String text = username + "님의 아이디는" + userid + "입니다.";

		MailDTO dto2 = new MailDTO();
		dto2.setMailTo(mailTo);
		dto2.setText(text);

		sendMail(dto2);

		session.setAttribute("mailTo", mailTo);
		session.setAttribute("username", username);
		session.setAttribute("userid1", userid1);

		return "completedForm_id";
	}

	@RequestMapping("/memberPW_emailSearch")
	public String memberPW_emailSearch(@RequestParam final Map<String, String> map, HttpSession session) {

		String nextPage = "";

		int n = service.pwSearch_email(map);

		if (n == 1) {
			char[] passwd2 = new char[10];

			for (int i = 0; i < 10; i++) {
				if (i % 2 == 0)
					passwd2[i] = (char) (48 + (int) (Math.random() * 10));
				else
					passwd2[i] = (char) (65 + (int) (Math.random() * 26));
			}

			final String passwd = new String(passwd2);

			Map<String, String> map2 = new HashMap();

			map2.put("userid", map.get("userid"));
			map2.put("passwd", passwd);

			MemberService service2 = new MemberService();
			int n2 = service.passwdUpdate(map2);

			String mailTo = map.get("email");
			String text = "[" + map.get("username") + "] 님의 아이디[" + map.get("userid") + "]  의 임시비밀번호는 [" + passwd
					+ "] 입니다.";

			MailDTO dto2 = new MailDTO();
			dto2.setMailTo(mailTo);
			dto2.setText(text);

			sendMail(dto2);

			session.setAttribute("mailTo", map.get("email"));
			session.setAttribute("username", map.get("username"));
			session.setAttribute("userid", map.get("userid"));
			session.setAttribute("passwd", passwd);

			nextPage = "completedForm_pw";

		} else {

			nextPage = "memberPWSearchUI";
			session.setAttribute("mesg", "입력하신 정보로 가입 된 회원 아이디는 존재하지 않습니다.");
		}

		return nextPage;
	}

}
