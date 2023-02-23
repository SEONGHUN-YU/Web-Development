package com.yu.bpbascp.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ByeController")
public class ByeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) { // 탈퇴
			MemberDAO.bye(request); // DB작업만 진행함
			MemberDAO.logout(request); // 세션도 날려줘야 함
			MemberDAO.isLogined(request); // 로그인(세션) 상태 확인으로 접속도 끊어줘야 함
			// 이 사이트의 로그인 : 세션
		} // 세션 만료일 때 탈퇴 누르면 탈퇴 안 시켜야 함
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
