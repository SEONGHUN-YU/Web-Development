package com.yu.feb171ct.jstlf;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DataGenerator {
	public static void generate(HttpServletRequest req) {
		int a = 123456789;
		req.setAttribute("aaa", a);

		double b = 0.123456789;
		req.setAttribute("bbb", b);

		String c = "12345.23456";
		req.setAttribute("ccc", c);

		String d = "2023-02-20";
		req.setAttribute("ddd", d);

		Date e = new Date();
		req.setAttribute("eee", e);
	}
}
