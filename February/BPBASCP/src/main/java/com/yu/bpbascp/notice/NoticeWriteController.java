package com.yu.bpbascp.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.bpbascp.main.TokenGenerator;
import com.yu.bpbascp.member.MemberDAO;

@WebServlet("/NoticeWriteController")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 글 쓰러가기
	//		로그인 : write.jsp로
	//		로그인 풀림 : 홈
	// 글쓰기
	//		로그인 : DB작업 후 -> notice.jsp로 가는 게 제일 이상적임, (write.jsp, home.jsp 둘 다 별로임)
	//		로그인 풀림 : 홈
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) {
			if (!request.getParameterNames().hasMoreElements()) {
				TokenGenerator.generate(request); // 글 쓰러 갈 때마다 해주도록
				request.setAttribute("contentPage", "notice/write.jsp");
			} else {
				NoticeDAO.getNoticeDAO().clearSearch(request);
				NoticeDAO.getNoticeDAO().write(request);
				NoticeDAO.getNoticeDAO().get(request, 1);
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
