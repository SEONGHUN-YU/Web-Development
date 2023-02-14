package com.yu.feb141jm2.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller
//		사이트 진입점(대문 같은 역할)
//		상황판단해서 M/V 소환
//		웹에서의 상황판단 : 요청 구별이 핵심, 어떤 요청이 들어왔나?
//		Servlet or JSP
//		JSP는 GET/POST 구별이 안 되니 -> Servlet
//		리더급 back-end가 다루는 곳

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 어떤 사이트에 처음 들어갈 때 -> GET방식 요청으로
	// 1.주소를 타이핑해서 사이트에 들어감
	// 2.포털에 검색해서 클릭해서 들어감 : <a>태그임
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("input.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Calculator.add(request);
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}
}
