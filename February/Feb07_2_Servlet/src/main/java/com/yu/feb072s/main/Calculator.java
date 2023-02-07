package com.yu.feb072s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 주소의 구조
	// 프로토콜:// - 통신방식(http or https)
	// IP주소(도메인네임) - 서버주소
	// :포트번호 - 80번이면 생략 가능
	// /폴더명/폴더명/... - ROOT면 생략 가능
	// 파일명 - index.html이면 생략 가능
	// ? <- 구분자
	// reqParam변수명=값&reqParam변수명=값&... - request parameter(요청 파라메터)

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("euc-kr");
		PrintWriter pw = response.getWriter();

		// request parameter 값 읽기
		// String 변수명 = request.getParameter("reqParam변수명");

		// .../Calculator?xxx=100&yyy=50
		String xxxx = request.getParameter("xxx");
		int x = Integer.parseInt(xxxx);

		String yyyy = request.getParameter("yyy");
		int y = Integer.parseInt(yyyy);

		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		pw.print("<table border=\"1\">");
		pw.printf("<tr><th>%d + %d = %d</th></tr>", x, y, x + y);
		pw.printf("<tr><th>%d - %d = %d</th></tr>", x, y, x - y);
		pw.printf("<tr><th>%d * %d = %d</th></tr>", x, y, x * y);
		pw.printf("<tr><th>%d / %d = %d</th></tr>", x, y, x / y);
		pw.print("</table>");
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
