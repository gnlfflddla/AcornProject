package com.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.ChoolCheckDTO;
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
	
	public ChoolCheckDTO choolCheck (String check) {
		ChoolCheckDTO dto = null;
			dto=dao.choolCheck(check);
		return dto;
	}
	
	public int choolInsert (HashMap<String, String> map) {
		int n = 0;
			n=dao.choolInsert(map);
		return n;
	}
	
	public int choolUpdate (HashMap<String, String> map) {
		int n = 0;
			n=dao.choolUpdate(map);
		
		return n;
	}
	
	public int choolClear (String check) {
		int n = 0;
			n=dao.choolClear(check);
		
		return n;
	}
	
	public List<MemberDTO> memberSelect (){
		List<MemberDTO> list = null;
			list = dao.memberSelect();
		return list;
	}
	
	public int expiration (String check) {
		int n=0;
		n=dao.expiration(check);
		return n;
	}
	
	public int randomMileage (HashMap<String, Object> mileageMap) {
		int n=0;
		n=dao.randomMileage(mileageMap);
		return n;
	}
	
	
}
