package com.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ChoolCheckDTO;
import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate session;

	public int memberAdd(MemberDTO dto) {
		int n=session.insert("MemberMapper.memberAdd",dto);
		return n;
	}
	public String pw(String id){
		String pw=session.selectOne("MemberMapper.pw",id);
		return pw;
	}
	
	public MemberDTO login(String userid) {
		MemberDTO dto=session.selectOne("MemberMapper.login",userid);
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
	
	public List<MemberDTO> memberSelect (){
		return session.selectList("MemberMapper.memberSelect");
	}
	
	public int expiration (String check) {
		return session.update("ChoolSeokMapper.expiration", check);
	}
	
	public int randomMileage (HashMap<String, Object> mileageMap) {
		System.out.println("확률 마일리지 "+mileageMap);
		return session.update("ChoolSeokMapper.randomMileage", mileageMap);
	}
}
