package com.yu.feb072s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
@WebServlet("/GugudanServlet")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GugudanServlet() {
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
		for (int i = 2; i < 10; i++) {
			pw.print("<table border=\"1\" style=\"float:left;\">");
			pw.printf("<tr><th>%d단</th></tr>", i);
			for (int j = 1; j < 10; j++) {
				pw.printf("<tr><td>%d x %d = %d</td></tr>", i, j, i * j);
			}
			pw.print("</table>");
		}
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
