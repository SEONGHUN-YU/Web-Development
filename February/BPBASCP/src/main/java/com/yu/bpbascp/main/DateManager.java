package com.yu.bpbascp.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {
	public static void getCurYear(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int curYear = Integer.parseInt(sdf.format(now));
		req.setAttribute("cy", curYear);
	}
}
