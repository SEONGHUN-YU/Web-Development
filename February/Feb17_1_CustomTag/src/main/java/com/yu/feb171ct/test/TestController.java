package com.yu.feb171ct.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 웹서버 : CPU/RAM이 중요하지, HDD용량이 그렇게 중요하지는 않음
	// DB서버 : HDD용량이 중요시 되니 변수로 정리할 수도 있지
	
	// 연습페이지로 들어올 때 [index.jsp에서 연습 눌렀을 때 - parameter 없음]
	// 연습페이지로 숫자쓰고 확인버튼 눌렀을 때 [yeah라는 parameter가 있다]
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("cp", "test/input.jsp");
		} else {
			request.setAttribute("cp", "test/output.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		// request.getRequestDispatcher("jsp/test/input.jsp").forward(request, response);
		// 직접 보내려면 이렇게 하겠지만 우리는 include에 있는 EL값을 바꿔주면서 이동시킬 거라 밑에 처럼
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
