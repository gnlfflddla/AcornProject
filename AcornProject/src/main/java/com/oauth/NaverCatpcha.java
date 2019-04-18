package com.oauth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class NaverCatpcha {

	private final static String CLIENT_ID = "IO_Q4VinyOrQEX1U_a6k";
	private final static String CLIENT_SECRET = "nwbtxhdA2p";

	//키 발급
	public String APIExamCaptchaNkey() {
		StringBuffer response;
		String key="";
		try {
			String code = "0"; // 키 발급시 0, 캡차 이미지 비교시 1로 세팅
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
			con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			response = new StringBuffer();
			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
				System.out.println("inputLine"+inputLine);
			}
			
			br.close();
			key=(response.toString()).substring(8,response.toString().length()-2);
		} catch (Exception e) {
			System.out.println(e);
		}
		return key;
	}
	
	//캡차 이미지 수신
	public String APIExamCaptchaImage(String key) {
		String tempname="";
		try {
			System.out.println("APIExamCaptchaImage : "+key);
            // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
            String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
            con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
            int responseCode = con.getResponseCode();
            System.out.println("responseCode : "+responseCode);
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로  파일 생성
                tempname = Long.valueOf(new Date().getTime()).toString();
                File f = new File("C:\\upload\\captcha",tempname + ".jpg");
                
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return tempname;
	}
	
	//키 발급, 키 비교
	public String APIExamCaptchaNkeyResult(String key, String captcha) {
		String result="";
		try {
            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
           // String captcha = "6REU41CF"; // 사용자가 입력한 캡차 이미지 글자값
            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ captcha;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
            con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println("APIExamCaptchaNkeyResult"+response);
            br.close();
            System.out.println(response.toString());
            result=response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
		String test = result.substring(10,14);
		return test;
	}
}
