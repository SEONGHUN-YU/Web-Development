package com.yu.feb171ct.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void getResult(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("euc-kr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String s = req.getParameter("calcValue");
		
		String[] str = s.split("\r\n");
		int result = 0;
		for (String n : str) {
			try {
				result += Integer.parseInt(n);
			} catch (Exception e) {
			}
		}
//		StringTokenizer st = new StringTokenizer(s, "\r\n");
//		while (st.hasMoreTokens()) {
//			try {
//				result += Integer.parseInt(st.nextToken());
//			} catch (Exception e) {
//			}
//		}
		req.setAttribute("calcResult", result);
	}
}
