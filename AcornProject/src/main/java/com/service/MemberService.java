package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.MemberDAO;
import com.dto.ChoolCheckDTO;
import com.dto.MemberDTO;

public class MemberService {
	@Autowired
	MemberDAO dao;
	
	public int memberAdd(MemberDTO dto) {
			return dao.memberAdd(dto);
	}
	public ChoolCheckDTO choolCheck (String check) {
			return dao.choolCheck(check);
	}
	public MemberDTO login(Map<String, String> map) {
			return dao.login(map);
	}
	
	public HashMap<String, String> idSearch(MemberDTO dto) {
		return dao.idSearch(dto);
	}
	
	public int idCheck(String userid) {
		return dao.idCheck(userid);
	}
	
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}
	
	public int withdrawal(HashMap<String, String> map) {
		return dao.withdrawal(map);
	}
	
	public int pwSearch_phone(HashMap<String, String> map) {
		return dao.pwSearch_phone(map);
	}
	
	public int pwSearch_email(HashMap<String, String> map) {
		return dao.pwSearch_email(map);
	}
	
	public int passwdUpdate(HashMap<String, String> map2) {
		return dao.passwdUpdate(map2);
	}
	public int choolInsert (HashMap<String, String> map) {
		return dao.choolInsert(map);
	}
	public int choolUpdate (HashMap<String, String> map) {
		return dao.choolUpdate(map);
	}
	
	public int choolClear (String check) {
		return dao.choolClear(check);
	}
}
