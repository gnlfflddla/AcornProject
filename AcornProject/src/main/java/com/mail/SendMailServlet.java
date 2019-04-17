package com.mail;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.MailDTO;
import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class SendMailServlet {

	@Autowired
	MemberService service;
	
	public void send(String title, String email, String mesg, String contant) {
		String host = "smtp.naver.com";
	    String subject = title;
	    String from = "gijunzzang@naver.com"; //보내는 메일
	   String fromName = "Acorn 쇼핑몰";
	    String to = email; //받는 메일
	    String content =  mesg +"\n"+ contant;
	    
	   try{
	     //프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
	     Properties props = new Properties();
	     //네이버 SMTP 사용시
	    props.put("mail.smtp.starttls.enable","true");
	     props.put("mail.transport.protocol","smtp");
	     props.put("mail.smtp.host", host);
	     
	     props.put("mail.smtp.port","465");  // 보내는 메일 포트 설정
	    props.put("mail.smtp.user", from);
	     props.put("mail.smtp.auth","true");
	     props.put("mail.smtp.debug", "true");
	     props.put("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	     props.put("mail.smtp.socketFactory.fallback", "false");


	     Authenticator auth = new SendMail2();
	     Session mailSession = Session.getDefaultInstance(props,auth);
	   
	     Message msg = new MimeMessage(mailSession);
	     msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
	    InternetAddress[] address = {new InternetAddress(to)};
	    
	     msg.setRecipients(Message.RecipientType.TO, address); //받는 사람설정
	   
	     msg.setSubject(subject); //제목설정
	    msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
	    msg.setContent(content,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
	    
	     Transport.send(msg); //메일 보내기

	     }catch(MessagingException ex){
	      System.out.println("mail send error : "+ex.getMessage());
	       ex.printStackTrace();
	     }catch(Exception e){
	      System.out.println("error : "+e.getMessage());
	       e.printStackTrace();
	     }
	}
	
		@RequestMapping("/mail")
		public String mail(MailDTO dto, HttpSession session) {
		
			System.out.println(dto);
		List<MemberDTO> list = service.memberSelect();
		HashMap<String, String> map = new HashMap<>();
		 String mesg = null;		
		 
		for (MemberDTO x : list) {
			System.out.println(x.getUsername());
			System.out.println(x.getGradeno());
			System.out.println(x.getEmail1());
			System.out.println(x.getEmail2());

			 if(dto.getGradenoS()==null) {
				// nextPage="gradeMail.html";
				 session.setAttribute("mesg", "등급이 정해져 있지 않습니다.");
			 }else {
				// nextPage="SendMailServlet";
				 if("S급".equals(x.getGradeno())) {
					 mesg = "고객님은 S등급 회원으로써"+ dto.getGradenoS()+"%할인 쿠폰을 보내드립니다";
				 } else if("A급".equals(x.getGradeno())) {
					 mesg = "고객님은 A등급 회원으로써"+ dto.getGradenoA()+"%할인 쿠폰을 보내드립니다";
				 } else if("B급".equals(x.getGradeno())) {
					 mesg = "고객님은 B등급 회원으로써"+ dto.getGradenoB()+"%할인 쿠폰을 보내드립니다";
				 } else if("C급".equals(x.getGradeno())) {
					 mesg = "고객님은 C등급 회원으로써"+ dto.getGradenoC()+"%할인 쿠폰을 보내드립니다";
				 } else if("D급".equals(x.getGradeno())) {
					 mesg = "고객님은 D등급 회원으로써"+ dto.getGradenoD()+"%할인 쿠폰을 보내드립니다";
				 }
				 
				 map.put("mailTo", x.getEmail1()+x.getEmail2());
				 map.put("title", dto.getTitle());
				 map.put("contents", dto.getContents());
				 map.put("gradeno", x.getGradeno());
				 map.put("mesg",mesg);
				 send(dto.getTitle(),x.getEmail1()+x.getEmail2(), mesg, dto.getContents());
				 System.out.println(x.getUserid()+mesg);
			 }
		}	
			
				return "main";
	}
		 	

}
