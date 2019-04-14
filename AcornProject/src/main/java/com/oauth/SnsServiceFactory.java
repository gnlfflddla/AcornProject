package com.oauth;

import javax.servlet.http.HttpServletRequest;

public class SnsServiceFactory {

	private HttpServletRequest request;
	
	 public SnsServiceFactory(HttpServletRequest request) {
	        this.request = request;
	    }
	
}
