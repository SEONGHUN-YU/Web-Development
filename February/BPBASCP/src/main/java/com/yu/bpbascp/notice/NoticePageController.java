package com.yu.bpbascp.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.bpbascp.member.MemberDAO;

@WebServlet("/NoticePageController")
public class NoticePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) {
			NoticeDAO.getNoticeDAO().get(request, Integer.parseInt(request.getParameter("p"))); // notice.jsp 페이지 번호
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
