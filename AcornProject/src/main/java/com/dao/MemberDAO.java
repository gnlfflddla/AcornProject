package com.dao;



import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate session;

	public int memberAdd(MemberDTO dto) {
		int n=session.insert("MemberMapper.memberAdd",dto);
		return n;
	}
	
	public MemberDTO login(Map<String, String> map) {
		MemberDTO dto=session.selectOne("MemberMapper.login",map);
		return dto;
	}
	
	public Map<String, String> idSearch(MemberDTO dto) {
		Map<String, String> map=session.selectOne("MemberMapper.idSearch",dto);
		return map;
	}
	
	public int idCheck(String userid) {
		int n=session.selectOne("MemberMapper.idCheck",userid);
		return n;
	}
	
	public int update(MemberDTO dto) {
		int n=session.update("MemberMapper.memberupdate",dto);
		return n;
	}
	
	public int withdrawal(Map<String, String> map) {
		
		int n=session.delete("MemberMapper.withdrawal",map);
		return n;
	}
	
	public int pwSearch_phone(Map<String, String> map) {
		int n=session.selectOne("MemberMapper.pwSearch_phone",map);
		return n;
	}
	
	public int pwSearch_email(Map<String, String> map) {
		int n=session.selectOne("MemberMapper.pwSearch_email",map);
		return n;
	}
	
	public int passwdUpdate(Map<String, String> map2) {
		System.out.println(map2);
		int n=session.update("MemberMapper.passwdUpdate",map2);
		return n;
	}
	
	public MemberDTO Naverlogin(String id) {
		MemberDTO dto=session.selectOne("MemberMapper.naverlogin",id);
		return dto;
	}
}
