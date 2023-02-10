package com.yu.feb092vc.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Uploadpic
 */
@WebServlet("/Uploadpic")
public class Uploadpic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Uploadpic() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("euc-kr");
		MultipartRequest mr = new MultipartRequest(request, request.getSession().getServletContext().getRealPath("pic"),
				31457280, "euc-kr", new DefaultFileRenamePolicy()); // 경로 (폴더명)

		// 자동완성 아닌 부분
		// 쌩 String부분 : 왜?

		// valid check(입력 유효성 검사)
		// 개발자가 의도한대로 입력했나 검사
		// if || try - catch

		// Servlet까지 와서 검사하다보니 <- Bad
		// 통신을 하게 됨 -> 데이터요금 지출
		// 서버가 일을 하게 됨 -> 그거 아니라도 바쁜데

		// 잘못 썼으면 Servelt쪽으로 출발도 안 하게 <- Better
		// 통신을 안 하니 -> 데이터 요금 안 나감
		// 서버가 일을 안 하니 -> 원래 임무만

		// 직원 : 직원 본인도 포맷할 줄 아는데, 굳이 쌤한테 포맷해달라고 한다면?
		// 쌤 : 윈도우 포맷 잘함
		// 수업하기도 바쁨

		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
//		try {
		String f = URLEncoder.encode(mr.getFilesystemName("pic"), "euc-kr").replace("+", " "); // input 태그 name
		int w = Integer.parseInt(mr.getParameter("width"));
		int h = Integer.parseInt(mr.getParameter("height"));
		pw.print("<h1>전송완료</h1>");
		pw.printf("<img src=\"pic/%s\" width=\"%dpx\" height=\"%dpx\">", f, w, h); // 여기 들어가는 pic는 저장된 폴더명
//		} catch (Exception e) {
//		}
		pw.print("</body></html>");
	}
}
