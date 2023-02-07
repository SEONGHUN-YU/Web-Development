package com.yu.feb072s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewGugudan
 */

@WebServlet("/NewGugudan")
public class NewGugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewGugudan() {
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

		// .../NewGugudan?dan=5&border=3
		int dan = Integer.parseInt(request.getParameter("dan"));
		int border = Integer.parseInt(request.getParameter("border"));

		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		pw.printf("<table border=\"%d\" style=\"float:left;\">", border);
		pw.printf("<tr><th>%d단</th></tr>", dan);
		for (int i = 1; i < 10; i++) {
			pw.printf("<tr><td>%d x %d = %d</td></tr>", dan, i, dan * i);
		}
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
