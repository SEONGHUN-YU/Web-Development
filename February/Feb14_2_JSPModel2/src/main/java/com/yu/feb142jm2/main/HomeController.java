package com.yu.feb142jm2.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 사이트 첫 접속은 GET방식일 수 밖에 없음 <- parameter 유무로 구분하여 처리 index일 때는 parameter가 없을테니
	// 버튼 누른 게 GET으로 올 경우는??
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("input.html").forward(request, response);
		} else {
			UnitConverter.getUC().convert(request); // 변환버튼 누른 게 오면 변환작업을 수행하고
			request.getRequestDispatcher("output.jsp").forward(request, response); // 결과페이지로 이동시켜주고 값도 보내준다
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UnitConverter.getUC().convert(request);
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}
}
