package com.yu.feb081s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Output
 */
@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	// main()은 tomcat에
	// Output객체는 tomcat이 만들고, 이벤트 루프(무한루프)시작
	// Output()이 발동하는 순간 : 최초로 서비스 시작할 때 딱 처음 1번 [껐다가 키면 다시 가능한 듯]
	public Output() {
		super();
		System.out.println("이 사이트 첫 시작 [tomcat키면]");
	}

	// GET방식 : 요청 파라메터가 주소에
	// 주소창에서 ㅋ(한글)은-> %@A 뭔가로 바뀜
	//					%@A	-> ㅋ 
	//		문자열을 URL인코딩으로 바꿔주고, 원상복구 시키는 작업을 tomcat이 자동으로 함 [iso-8859-1]방식, [euc-kr]방식과 안 맞아서 깨져서 나오는 것
	//		=> 얘는 
	
	// POST방식 : 요청 파라메터가 주소에 없고, 내부적으로 전달(보안성 높음)
	//
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		request.setCharacterEncoding("euc-kr"); 얘는 이거 써도 안 됨, Tomcat 설정 건드려야 함
		response.setCharacterEncoding("euc-kr");
		PrintWriter pw = response.getWriter();

		int a = Integer.parseInt(request.getParameter("aa"));
		String s = request.getParameter("bb");
		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		pw.printf("<h1>%d : %s<h1>", a, a % 2 == 0 ? "짝수" : "홀수");
		pw.printf("<h1>%s<h1>", s);
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr"); // Post방식에서 이게 있어야 한글 안 깨짐
		response.setCharacterEncoding("euc-kr");
		PrintWriter pw = response.getWriter();

		int a = Integer.parseInt(request.getParameter("aa"));
		String s = request.getParameter("bb");
		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		pw.printf("<h1>%d : %s<h1>", a, a % 2 == 0 ? "짝수" : "홀수");
		pw.printf("<h1>%s<h1>", s);
		pw.print("</body></html>");
	}

}
