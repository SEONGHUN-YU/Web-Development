package com.yu.bpbascp.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.bpbascp.main.DateManager;

@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 가입하러 가기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DateManager.getCurYear(request);
		MemberDAO.isLogined(request);
//		request.setAttribute("loginPage", "member/login_2btn.jsp");
		request.setAttribute("contentPage", "member/join.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	
	// 가입하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO.join(request);
		MemberDAO.isLogined(request);
//		request.setAttribute("loginPage", "member/login_2btn.jsp");
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}
