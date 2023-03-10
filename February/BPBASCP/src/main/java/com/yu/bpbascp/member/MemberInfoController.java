package com.yu.bpbascp.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) {
			request.setAttribute("contentPage", "member/info.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) {
			MemberDAO.update(request); // DB쪽 작업은 끝인데 세션데이터는 그대로임
			MemberDAO.updateSession(request); // 세션데이터 업데이트가 안 되어 있었는데 갱신해줌
			request.setAttribute("contentPage", "member/info.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}
