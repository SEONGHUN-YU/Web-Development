package com.yu.feb162ct.baseball;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BaseballController")
public class BaseballController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Baseball.getBASEBALL().resetScore(request);
		Baseball.getBASEBALL().start(request);
		request.setAttribute("contentPageHaha", "baseball/output.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Baseball.getBASEBALL().play(request);
		request.setAttribute("contentPageHaha", "baseball/output.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}
