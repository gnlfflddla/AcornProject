package com.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;


public class SendMail {

	@Autowired
	private  JavaMailSenderImpl mailSender;

	
	public String sendMail(final MailDTO dto){
			System.out.println("11"+dto);
			
		final MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 
				
				System.out.println(dto);
				
				String text=dto.getText();
				String mailTo=dto.getMailTo();
				
				helper.setFrom("swih0910@naver.com"); 
				helper.setTo(mailTo); 
				helper.setSubject( "acorn 쇼핑몰 인증번호 발송"); 
				helper.setText("인증번호:"+ text , true); 
			}
		};
			
			mailSender.send(preparator);
		
		return "dd";

	}
}
