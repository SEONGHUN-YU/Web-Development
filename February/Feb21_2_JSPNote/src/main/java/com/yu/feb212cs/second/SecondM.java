package com.yu.feb212cs.second;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondM {
	// request parameter
	//		front-end쪽에서 만들어진 값
	//		GET방식 : 주소에 실려서 보내짐
	//				톰캣설정(server.xml)으로 한글처리
	//		POST방식 : 내부적으로 처리해서 보내짐
	//				req.setCharacterEncoding("");으로 한글처리 euc-kr, utf-8, ...
	//		String or String[]으로 옴
	//		Java로 받자 : req.getParameter("파라메터명");
	//		EL로 받자 : ${param.파라메터명}
	//		request소속
	
	// request attribute
	//		back-end쪽에서 만들어진 값
	//		Object면 다 됨 (기본형들은 boxing 해서 들어감)
	//		Java에서 읽기 : req.getAttribute("어트리뷰트명");
	//		EL로 읽기 : ${어트리뷰트명}
	//		request소속
	
	// session attribute
	//		back-end쪽에서 만들어진 값
	//		Object
	//		Java에서 읽기 : hs.getAttribute("어트리뷰트명"); 방법은 같은데 소속이 다름
	//		EL로 읽기 : ${sessionScope.어트리뷰트명}
	//		session소속(서버-사용자간의 연결상태(구름다리)에 저장됨)
	//			기본 유지시간 30분
	//		주로 로그인시스템에 씀, 사용자 개인의 공간 
	
	// cookie
	//		back-end쪽에서 만들어진 값
	//		String만 있음
	//		Java에서 읽기 : 길어서... 찾아서 해보길
	//		EL로 읽기 : ${cookie.쿠키명.value}
	//		사용자 pc소속
	//		사용자 pc에 파일로 저장됨 - 보안은?? -> 매우 위험한 애
	//			윈도우에서 볼 수 있음 [요즘은 암호화 돼서 저장되기는 한다고 함]
	//		ID만 저장시켜서, 자동로그인(로그인상태유지) 같은 기능에 씀
	
	// firstV에서 or SecondM에서 만든 값을 thirdV까지 가지고 가고 싶은데
	// req parameter, req attribute는 안 됨
	
	public static void printData(HttpServletRequest req) {
		String v = req.getParameter("value");
		Integer v2 = Integer.parseInt(v);
		int v3 = v2.intValue();
		System.out.println(v3);
		
		Object j = req.getAttribute("k"); // <- 받고
		Integer j2 = (Integer) j;
		int j3 = j2.intValue();
		System.out.println(j3);
	}
	
	public static void makeData(HttpServletRequest req, HttpServletResponse res) {
		int k = 20;
		Integer kk = new Integer(k);
		req.setAttribute("k", kk); // <- 주고
		
		double d = 3.14;
		Double dd = new Double(d);
		
		// 서버-사용자 연결상태
		HttpSession hs = req.getSession();
		hs.setMaxInactiveInterval(5); // 세션 유지시간 설정, 단위는 초
		// 직접 브라우저를 끄거나
		// 세션 유지시간동안 request를 안 하면
		// 세션이 끊기면 -> ddd는 없어짐
		// 유지시간내에 request를 하면 갱신(다시 5초부터)
		hs.setAttribute("ddd", dd);
		
		int ttt = 30;
		String s = ttt + "";
		Cookie c = new Cookie("aaa", s); // cookie를 쓰려면 response 객체가 필요하다, 그래서 method parameter로 가져옴
		// 무조건 10초동안 살아있음
		c.setMaxAge(10); // 쿠키 유지시간 설정, 단위는 초
		res.addCookie(c);
		
		// ID에 한글 써도 되긴 하는데
		// 개발자가 귀찮아서 못 쓰게 하는 게 일반적
		
		// 옛날에는 쿠키에 한글 넣으면 안 됐었음
		// ㅋ -> %2A (URL인코딩 형태로 넣어야 했음) <- 이것 때문에 ID에 한글 못 쓰게 하는 문화가 생겼다고 봐도...
		Cookie c2 = new Cookie("bbb", "ㅋㅋㅋ");
		res.addCookie(c2);
	}
}
