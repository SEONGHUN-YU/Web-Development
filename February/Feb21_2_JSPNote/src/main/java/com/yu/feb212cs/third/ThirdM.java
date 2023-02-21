package com.yu.feb212cs.third;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ThirdM {
	
	public static void printData(HttpServletRequest req) {
//		int value = Integer.parseInt(req.getParameter("value"));
//		int k = (Integer) req.getAttribute("k");
//		System.out.println(value);
//		System.out.println(k); 얘네로는 안 됨
		
//		HttpSession hs = req.getSession();
//		Object c = hs.getAttribute("ddd");
//		Double cc = (Double) c;
//		double ccc = cc.doubleValue();
//		System.out.println(ccc);
		
		// 여태 인터넷 하느라, 다양한 사이트들이 쿠키를 만들어놨을 것
		Cookie[] cookies = req.getCookies(); // 지금 만들어져있는 쿠키들
		for (Cookie ck : cookies) {
			if (ck.getName().equals("aaa")) {
				System.out.println(ck.getValue());
			}
		}
	}
}
