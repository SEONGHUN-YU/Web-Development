package com.yu.feb141jm2.main;

import javax.servlet.http.HttpServletRequest;

// Model
//		실제 계산, 결과는 req attribute에
//		back-end 개발자 + 고객
public class Calculator {
	public static void add(HttpServletRequest req) {
		int x = Integer.parseInt(req.getParameter("xv"));
		int y = Integer.parseInt(req.getParameter("yv"));
		int z = x + y;
		req.setAttribute("zv", z);
	}
}
