package com.yu.feb072s.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Event-driven Programming <- ↓ 이런 스타일의 구조
// Tomcat이 실행 중
//		Tomcat이 FirstServlet 객체를 만들고
//		Tomcat 꺼질 때까지 무한 루프
//		클라이언트 요청 받은 거 처리해주고, 무한루프로 복귀

// Servlet(Server + Applet) (Applet <- Application의 옛날말?)
//	WAS에서만 실행 가능한 => main이 tomcat에 있음
//	클라이언트한테 요청 받으면
//	HTML/CSS를 만들어서 응답해주는
//	Java프로그램

// @XXX : annotation
//		XXX에 뭐 있냐에 따라 다 다름
//		대부분의 기능 : [원래 수동설정을 해야하는데, annotation쓰면 자동으로 됨]
//		↑ 매우 자주 쓰이는 쓰임방식

// 원래] : Servlet만들면 Tomcat에 등록해야 쓸 수 있음

/**
 * Servlet implementation class FirstServlet <- 여기도 바꿔주면 그냥 기분이 좋다(여기는 안 바꿔도 된다는
 * 말)
 */
@WebServlet("/FirstServlet") // <- 이거는 톰캣에 자동 등록해주는 기능, <- 클래스명을 바꿔도 이 곳은 안 바뀐다, 매우 주의! 매우 중요! 안 맞으면 수동으로 바꿔줄
								// 것
public class FirstServlet extends HttpServlet {
	// HttpServlet의 기능 다 물려받고 + 기능 추가 <- extends(상속)

	// 작업하면서 버전 표시하라고 만들어 준(지워도 되긴하는데 그냥 냅두자)
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	// main은 어디? <- Tomcat
	// 언제 만들어지나? <- Tomcat이 알아서
	// 객체 만들어 질 때 뭐 하려면 : 생성자 <- 여기선 쓸 일이 없을 거 같긴한데...
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 인터넷에서
	// 주소를 알아서 직접 쳐서 들어가는 거 : GET방식 요청
	// 검색해서 <a href=""></a> : GET방식 요청
	// 대부분 GET방식이다
	// POST방식 요청은 특별한 기술로만 가능

	// 이벤트 루프 돌다가
	// 클라이언트로부터 GET요청 받으면
	// tomcat이 알아서 이거 호출함
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// html + css를 만들어서
		System.out.println("누가 GET방식 요청함");
//		String html = "<html>";
//		html += "<head><meta charset=\"euc-kr\"></head>";
//		html += "<body>";
//		html += "<h1>apple</h1>";
//		html += "</body></html>";

		Random r = new Random();
		int x = r.nextInt(10);

		// 서버가 문자열인코딩을 무슨 방식으로 하고있나
		response.setCharacterEncoding("euc-kr");
		// 서버 : ㅋ -euc-kr-> 0101
		// 클라이언트 : 0101 -euc-kr-> ㅋ
		// 맞추어 주어야 함

		// 서버-클라이언트 사이의 랜선에 붙어있는 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print("<html>"); // html + css응답
		pw.print("<head><meta charset=\"euc-kr\"></head>");
		pw.print("<body>");
		pw.print("<h1>ㅋ</h1>");
		pw.printf("<marquee>%d</marquee>", x);
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 이벤트 루프 돌다가
	// 클라이언트로부터 POST요청 받으면
	// tomcat이 알아서 이거 호출함
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("누가 POST방식 요청함");
	}

}
