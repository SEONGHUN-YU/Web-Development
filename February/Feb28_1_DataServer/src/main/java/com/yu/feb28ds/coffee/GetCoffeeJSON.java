package com.yu.feb28ds.coffee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCoffeeJSON")
public class GetCoffeeJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// XML 	: HTML모양을 빌려서 - O, HTML - X
	// JSON : JavaScript모양을 빌려서 - O, JS - X
	//		JS객체 : {name : "홍", age : 10}
	//		JSON : {"name" : "홍", "age" : 10}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답하는 게 HTML이 아닌 JSON이라고 알아듣고
		// 크롬이 이걸 인식해서 이쁘게 보여준다
//		response.setContentType("application/json; charset=utf-8"); // AM's Knowledge
		response.addHeader("Content-Type", "application/json; charset=utf-8"); // XML도 사실은 application/xml 해주는 게 맞긴한데 자동으로 해줌
		response.setCharacterEncoding("uft-8");
		PrintWriter pw = response.getWriter();
		pw.write(CoffeeDAO.getCoffeeJSON(request));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
