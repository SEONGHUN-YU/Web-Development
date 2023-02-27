package com.yu.bpbascp.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.bpbascp.member.MemberDAO;

@WebServlet("/NoticeDetailController")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) {
			if (NoticeDAO.getNoticeDAO().getDetail(request)) {
				request.setAttribute("contentPage", "notice/detail.jsp");
			} else {
				NoticeDAO.getNoticeDAO().get(request, 1); // 보던 페이지에 남아 있으려면...
				request.setAttribute("contentPage", "notice/notice.jsp");
			}
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
