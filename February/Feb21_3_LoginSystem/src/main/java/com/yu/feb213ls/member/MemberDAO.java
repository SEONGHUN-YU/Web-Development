package com.yu.feb213ls.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	private static final MemberDAO MEMBERDAO = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getMDAO() {
		return MEMBERDAO;
	}

	// 로그인이 된 상태면 true, 안 된 상태면 false
	// 로그인 상태인지 아닌지 검사할 때 사용할 method
	public boolean isLogined(HttpServletRequest req) {
		return (req.getSession().getAttribute("loginID") != null);
	}

	public void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			// post 방식이니까
			req.setCharacterEncoding("euc-kr"); // 한글처리 해야하는데
			// 쿠키관련 작업량이 늘어나기에 ID에 한글 못 쓰게 할테니 사실 그닥 필요는 없다

			String id = req.getParameter("id");
			String pw = req.getParameter("pw");

			// 원래는 DB에 있을 ID, PW랑 비교해야하지만
			if (id.equals("test") && pw.equals("123")) {
				// 한번 로그인 성공하면, 시간이 초과되지 않는 이상, ID가 input에 계속 적혀있게 하고 싶음 <- cookie로
				Cookie c = new Cookie("loginID", id);
				c.setMaxAge(1 * 60 * 60 * 24);
				res.addCookie(c);

				// 로그인 정보
				// 로그인 해놓고 저 사이트에서 어딜 가든지 사용가능하게 해야함
				// 자리비우면 끊기게 해야함
				// 보안적으로 민감한 정보
				// => session attribute
				req.getSession().setAttribute("loginID", id);
				req.getSession().setAttribute("loginPW", pw);
				req.getSession().setMaxInactiveInterval(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
