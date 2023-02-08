package com.yu.feb082io.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinResult
 */
@WebServlet("/JoinResult")
public class JoinResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinResult() {
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

		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		pw.printf("<h1>%s</h1>", request.getParameter("name"));
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		PrintWriter pw = response.getWriter();

		// checkbox만 이렇게 받아야 함, 선택 아예 안 했을 때는 null값 <- 이 때 for문 돌리면 에러남
		String[] hobbys = request.getParameterValues("hobby");
		String[] ways = request.getParameterValues("way");

		// textarea에 쓴 값
		// textarea에서 엔터치면 : \r\n으로 가져옴
		// 가\r\n나\r\n\다 같은 느낌...
		// 웹에서 줄 바꿈은 <br> 인데...
		// \r\n을 <br>로 바꿔주는 작업을 해줘야 웹에서 쓸 수 있음
		String cmt = request.getParameter("cmt");
		cmt = cmt.replace("\r\b", "<br>"); // 웹에서 쓸 꺼면 바꿔주어야 하고 Java에서 쓸 거면 replace 해주지 않아야 값을 다루기 편하다

		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		pw.printf("<h1>%s</h1>", request.getParameter("name"));
		pw.printf("<h1>%s</h1>", request.getParameter("id"));
		pw.printf("<h1>%s</h1>", request.getParameter("pw"));
		pw.printf("<h1>%s</h1>", request.getParameter("addr"));
		pw.printf("<h1>%s</h1>", request.getParameter("house"));
		if (hobbys != null) {
			for (String str : hobbys) {
				pw.printf("<h1>%s</h1>", str);
			}
		}
		if (ways != null) {
			for (String str : ways) {
				pw.printf("<h1>%s</h1>", str);
			}
		}
		pw.printf("<h1>%s</h1>", cmt);
		pw.print("</body></html>");
	}
}
