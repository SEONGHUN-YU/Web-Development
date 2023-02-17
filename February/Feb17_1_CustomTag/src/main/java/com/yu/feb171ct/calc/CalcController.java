package com.yu.feb171ct.calc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 어차피 계산하는 M은 singleton인 경우가 많은데
	// => 연습하는 차원에서 singleton으로 해보던지
	// => 이제 그만 연습해도 되겠다 싶으면 판단해서, static or singleton으로
	// => 근데 사실 실전에서는 static 쓸 일이 거의 없긴하므로 singleton으로 연습하는 게 낫긴할 것
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cp", "calc/input.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Calculator.getResult(request);
		request.setAttribute("cp", "calc/output.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}
