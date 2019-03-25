package com.service;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;

	public int memberAdd(MemberDTO dto) {

		int n = 0;

		n = dao.memberAdd(dto);

		return n;
	}

	public MemberDTO login(Map<String, String> map) {

		MemberDTO dto = null;

		dto = dao.login(map);

		return dto;
	}

	public Map<String, String> idSearch(MemberDTO dto) {

		Map<String, String> map = null;

		map = dao.idSearch(dto);

		return map;
	}

	public int idCheck(String userid) {
		
		int count = 0;

		count = dao.idCheck(userid);

		return count;

	}

	public int update(MemberDTO dto) {

		int n = 0;

		n = dao.update(dto);

		return n;
	}

	public int withdrawal(Map<String, String> map) {

		int n = 0;

		n = dao.withdrawal(map);

		return n;
	}

	public int pwSearch_phone(Map<String, String> map) {

		int n = 0;

		n = dao.pwSearch_phone(map);

		return n;
	}

	public int pwSearch_email(Map<String, String> map) {

		int n = 0;

		n = dao.pwSearch_email(map);

		return n;
	}

	public int passwdUpdate(Map<String, String> map2) {

		int n = 0;

		n = dao.passwdUpdate(map2);

		return n;
	}
}
