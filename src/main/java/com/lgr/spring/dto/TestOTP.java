package com.lgr.spring.dto;

import java.util.Date;

public class TestOTP {
	
	public static void main(String[] args) throws Exception {
		OtpServer server = new OtpServer("HmacSHA1","test");
		OtpWAS was = new OtpWAS("HmacSHA1","test");
		
		long time = new Date().getTime();
		
		System.out.println(time);
		
		for (int i = 0; i < 180; i++) {
			System.out.printf("%d : ", i);
			System.out.println(was.vaildate(server.create("01055231605", time), "01055231605", time));
			Thread.sleep(1000);
		}
		
	}

	
}
