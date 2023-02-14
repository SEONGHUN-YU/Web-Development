package com.yu.feb143jm2.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// C
//		왜 Servlet? -> 요청 받아야해서
//			-> Servlet - v
//			-> JSP : GET/POST 구별이 안 되고, HTML 응답에 특화
//		뭔 소스를 어째서 거기다 썼나
//	 	누가 작업하는지 : 리더급 back-end개발자

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("input.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Doctor.getDoctor().calculate(request);
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}
}
