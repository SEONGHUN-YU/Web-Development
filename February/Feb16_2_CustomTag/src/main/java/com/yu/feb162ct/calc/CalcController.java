package com.yu.feb162ct.calc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			// 계산하러 들어올 때 갈 곳의 주소를 index.jsp의 include 값에 세팅해줌
			request.setAttribute("contentPageHaha", "calc/input.jsp");
		} else {
			// 계산하고나서 갈 곳, 출력페이지의 주소를 세팅해줌
			Calculator.getCALC().getValue(request);
			request.setAttribute("contentPageHaha", "calc/output.jsp");
		}
		// 어쨌든 이쪽으로 가게 됨 if문 바깥이라 조건에 상관없이 이동함
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
