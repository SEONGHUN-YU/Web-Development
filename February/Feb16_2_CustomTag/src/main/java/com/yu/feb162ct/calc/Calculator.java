package com.yu.feb162ct.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	private static final Calculator CALCULATOR = new Calculator();

	private Calculator() {
	}

	public static Calculator getCALC() {
		return CALCULATOR;
	}

	public void getValue(HttpServletRequest req) {
		int x = Integer.parseInt(req.getParameter("xx"));
		int y = Integer.parseInt(req.getParameter("yy"));
		int z = x + y;
		req.setAttribute("z", z);
	}
}
