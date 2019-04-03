package com.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.MemberDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.oauth.NaverLoginBO;
import com.service.MemberService;

@Controller
public class LoginController {

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;

	/* NaverLoginBO */
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@Autowired
	MemberService service;

	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map, HttpSession session, Model m) {

		// 네이버 로그인
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		m.addAttribute("url", naverAuthUrl);

		MemberDTO dto = service.login(map);

		String nextPage = null;
		if (dto != null) {
			session.setAttribute("login", dto);
			nextPage = "/main";
		} else {
			session.setAttribute("mesg", "아이디 또는 비빌번호를 다시 확인하세요.");
			nextPage = "redirect:/loginUI"; // 절대경로

		}

		return nextPage;

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}

	@RequestMapping("/loginUI")
	public ModelAndView login(HttpSession session) {
		/* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		/* 생성한 인증 URL을 View로 전달 */
		return new ModelAndView("loginForm", "url", naverAuthUrl);
	}

	// 네아로 인증을 완료 한 후 전달받은 정보를 이용하여 access token을 발급 받음
	@RequestMapping("/callback")
	public ModelAndView callback(@RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		/* 네아로 인증이 성공적으로 완료되면 code 파라미터가 전달되며 이를 통해 access token을 발급 */
		OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
		String apiResult = naverLoginBO.getUserProfile(oauthToken);

		// 받아온 프로필정보(Json형태)를 map으로 변환
		ObjectMapper mapper = new ObjectMapper();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map = mapper.readValue(apiResult, new TypeReference<Map<Object, Object>>() {
		});

		String id = (String) (((HashMap) map.get("response")).get("id"));
		// {"resultcode":"00","message":"success","response":{"id":"172761631","email":"swih0910@naver.com","name":"\uac15\uc778\ud61c","birthday":"09-10"}}

		int checkId = service.Naverlogin(id);
		String nextPage = "";
		if (checkId == 0) {
			session.setAttribute("naverInfo", map.get("response"));
			nextPage = "redirect:/agreementUI";

		} else {
			nextPage = "redirect:/main";
		}

		return new ModelAndView(nextPage);
	}
}
