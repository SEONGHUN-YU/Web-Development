package com.yu.feb201db.main;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Java + DB--------------------------------- Java랑 DB연결하는 방법 테크트리
	// 오리지널 JDBC : DB서버랑 연결해달라 하면
	// 그 때부터 세팅하고, 뭐하고, ... 다 끝나면
	// con 만들어서 줌 -> 느림...

	// ConnectionPool : con을 미리 몇 개 만들어 놓고
	// DB서버랑 연결해달라 하면
	// 만들어 놓은 거 주면 끝 -> 빠름
	// 이걸 Tomcat이 함

	// META-INF 폴더 : 그 프로젝트에만 적용되는 Tomcat 설정파일 넣는 폴더
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		try {
			// context.xml : 튜브 대여소 설계도
			//				Tomcat 설정파일
			//				다양한 거 등록해놓고 사용 가능
			Context ctx = new InitialContext();
			
			// 튜브 대여소
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/DBServer");
			
			// 튜브 : Connection
			con = ds.getConnection();
			System.out.println("연결 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
