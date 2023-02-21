package com.yu.feb212cs.first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	Controller
//		Servlet 아니면 .jsp인데
//	.jsp는 get/post 구별이 안 됨
//		Java 소스 자동완성이 뻑뻑하고
//		html응답에 특화된 녀석이라 Servlet을 Controller로 쓰는 게 낫다

@WebServlet("/FirstC")
public class FirstC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 사이트 첫 접속을 post로 하는 사람은 없다
	// 첫 접속은 항상 get방식이겠으니
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("firstV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
