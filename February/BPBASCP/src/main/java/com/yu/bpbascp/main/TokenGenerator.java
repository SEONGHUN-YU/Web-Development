package com.yu.bpbascp.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// 토큰값이 중복되면 : 새로고침된 걸로 판정
// 절대로 중복되지 않는 값이 필요 : 다양한 방법이 있다
public class TokenGenerator {
	public static void generate(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
		String token = sdf.format(now);
		req.setAttribute("token", token);
	}
}
