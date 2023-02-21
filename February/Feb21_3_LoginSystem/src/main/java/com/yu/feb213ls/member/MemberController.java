package com.yu.feb213ls.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO.getMDAO().login(request, response);
		if (MemberDAO.getMDAO().isLogined(request)) {
			// 로그인 성공시 welcome으로
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else {
			// 로그인 실패시 index로
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
