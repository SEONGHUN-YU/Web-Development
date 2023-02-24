package com.yu.bpbascp.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.bpbascp.member.MemberDAO;

@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시판
		//		로그인 안 해도 보여는 줄 건지
		//		로그인해야만 볼 수 있게 할 건지
		// 로그인 기능 있는데 정책 어떻게 할까? <- 팀끼리 상의해서 정하는 것
		if (MemberDAO.isLogined(request)) { // 이번 정책은 로그인 없으면 못 보게
			NoticeDAO.getNoticeDAO().get(request);
			request.setAttribute("contentPage", "notice/notice.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
