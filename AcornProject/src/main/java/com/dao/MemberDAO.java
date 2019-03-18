package com.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.ChoolCheckDTO;
import com.dto.MemberDTO;

public class MemberDAO {
	@Autowired
	SqlSessionTemplate session;
	
	
	public ChoolCheckDTO choolCheck (String check) {
		return session.selectOne("ChoolSeokMapper.choolCheck",check);
	}
	
	public int choolInsert (HashMap<String, String> map) {
		return session.insert("ChoolSeokMapper.choolInsert", map);
	}
	
	public int choolUpdate (HashMap<String, String> map) {
		return session.update("ChoolSeokMapper.choolUpdate", map);
	}
	
	public int choolClear (String check) {

		return session.update("ChoolSeokMapper.choolClear", check);
	}
	
	public int memberAdd(MemberDTO dto) {
		System.out.println(dto);
		int n=session.insert("MemberMapper.memberAdd",dto);
		return n;
	}
	public MemberDTO login(Map<String, String> map) {
		MemberDTO dto=session.selectOne("MemberMapper.login",map);
		return dto;
	}
	
	public HashMap<String, String> idSearch(MemberDTO dto) {
		HashMap<String, String> map=session.selectOne("MemberMapper.idSearch",dto);
		return map;
	}
	
	public int idCheck(String userid) {
		int n=session.selectOne("MemberMapper.idCheck",userid);
		System.out.println("idcheck DAO = "+n);
		return n;
	}
	
	public int update(MemberDTO dto) {
		int n=session.update("MemberMapper.memberupdate",dto);
		return n;
	}
	
	public int withdrawal(HashMap<String, String> map) {
		
		int n=session.delete("MemberMapper.withdrawal",map);
		return n;
	}
	
	public int pwSearch_phone(HashMap<String, String> map) {
		int n=session.selectOne("MemberMapper.pwSearch_phone",map);
		return n;
	}
	
	public int pwSearch_email(HashMap<String, String> map) {
		int n=session.selectOne("MemberMapper.pwSearch_email",map);
		return n;
	}
	
	public int passwdUpdate(HashMap<String, String> map2) {
		int n=session.update("MemberMapper.passwdUpdate",map2);
		return n;
	}
}
