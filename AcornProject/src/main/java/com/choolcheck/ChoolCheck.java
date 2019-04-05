package com.choolcheck;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.ChoolCheckDTO;
import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class ChoolCheck {

	@Autowired
	MemberService service;
	
	/*
	 * @RequestMapping("/m/choolTest") public String choolTest (HttpSession session,
	 * MemberDTO dto, RedirectAttributes test) { dto =
	 * (MemberDTO)session.getAttribute("login"); String check = dto.getUserid();
	 * ChoolCheckDTO checkDTO = service.choolCheck(check);
	 * 
	 * if(checkDTO == null) { test.addFlashAttribute("test", "test");
	 * 
	 * }
	 * 
	 * return "choolcheck"; }
	 */
	
	@RequestMapping("/m/choolcheck")
	public String choolcheck (HttpSession session, MemberDTO dto,
							RedirectAttributes viewMileage) {
	     dto = (MemberDTO)session.getAttribute("login");
	    String check = dto.getUserid();
	    ChoolCheckDTO checkDTO = service.choolCheck(check);
	    session.setAttribute("checkDTO", checkDTO);
	    System.out.println("check"+check);
	   System.out.println("checkDTO"+checkDTO);
	    
	    
		String pattern = "yyyy년 MM월 dd일";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		
		Date date = new Date();
		String checkDate = dateFormat.format(date);
		System.out.println(checkDate);
		System.out.println(check);
		
			
		
		
		String cMesg = null;
		HashMap<String, String> map = new HashMap<>();
		
		System.out.println(checkDTO);

		
		

	if(checkDTO == null) {
			System.out.println("if44");
			map.put("userid", check);
			map.put("timecheck", checkDate);
			service.choolInsert(map);
			System.out.println("map++"+map);
			session.setAttribute("checkid", map);
			cMesg = checkDate+"첫번째 출석이 완료 되었습니다.";
	}else {
	
		if (check.equals(checkDTO.getUserid())) {
			System.out.println("if1");
			if(checkDate.equals(checkDTO.getTimecheck())) {
				System.out.println("if2");
				System.out.println(checkDate.equals(checkDTO.getTimecheck()));
				cMesg = "이미 출석체크 하셨습니다.";
			} else {
				System.out.println("if3");
				map.put("userid", check);
				map.put("timecheck", checkDate);
				service.choolUpdate(map);
				session.setAttribute("checkid", map);
				cMesg = checkDate+" "+(checkDTO.getCount()+1)+"번째 출석이 완료 되었습니다.";
				int d = (int) (Math.random()*100)+1;
				System.out.println("확률" + d);
				HashMap<String, Object> mileageMap = new HashMap<>();
				if(d<=60) {
					mileageMap.put("userid", check);
					mileageMap.put("mileage", 10);
					service.randomMileage(mileageMap);
					viewMileage.addFlashAttribute("viewM", "10마일리지를 획득 하였습니다.");
					System.out.println("10");
				} else if (d<=85) {
					mileageMap.put("userid", check);
					mileageMap.put("mileage", 20);
					service.randomMileage(mileageMap);
					viewMileage.addFlashAttribute("viewM", "20마일리지를 획득 하였습니다.");
					System.out.println("20");
				} else if (d<=98){
					mileageMap.put("userid", check);
					mileageMap.put("mileage", 30);
					service.randomMileage(mileageMap);
					viewMileage.addFlashAttribute("viewM", "30마일리지를 획득 하였습니다.");
					System.out.println("30");
				} else {
					mileageMap.put("userid", check);
					mileageMap.put("mileage", 100);
					service.randomMileage(mileageMap);
					viewMileage.addFlashAttribute("viewM", "100마일리지를 획득 하였습니다.");
					System.out.println("100");
				}
				
			}
		}
		
		if(checkDTO.getCount() >= 29) {
			service.choolClear(check);
			
			cMesg = "30일을 다 채우셨습니다. 500 마일리지를 선물로 드립니다!";
			service.expiration(check);
		}
	}
		
		
		session.setAttribute("cMesg", cMesg);
		
		System.out.println(cMesg);
		
			return "redirect:/choolcheckUI";
		
	}
}
