package com.yu.bpbascp.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.bpbascp.member.MemberDAO;
import com.yu.bpbascp.notice.NoticeDAO;

// main() : Tomcat에 -> WAS에서만 실행됨
// Controller, .jsp 객체들은 Tomcat이 다 만듬
// 이벤트루프 돌려서 -> 요청 들어오면 해치우고 복귀
// event-driven programming

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Tomcat 시작시키면 -> 이 프로젝트에 있는 Controller들 .jsp들 객체 만듬 <- 이 때부터 이벤트 루프 돌아감
	public HomeController() { // Tomcat 시작시 1번만 생성한다는 의미로도 볼 수 있음
		NoticeDAO.getNoticeDAO().setAllNoticeCount();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO.isLogined(request);
//		request.setAttribute("loginPage", "member/login_2btn.jsp");
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
