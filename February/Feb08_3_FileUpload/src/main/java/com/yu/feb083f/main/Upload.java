package com.yu.feb083f.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Upload() {
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

	// 4. 다른 포장방식으로 데이터가 넘어오니, 데이터 읽는 게 바뀔 것
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("euc-kr"); <-
//		request.getParameter("title"); <- 이거 둘 다 안 됨
		response.setCharacterEncoding("euc-kr");

		// 4-1. 파일이 업로드될 폴더 서버상의 절대경로가 필요
		// 상대경로 -> 서버상의 절대경로
		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);

		// 4-2. 플라스틱 박스 [사실 5번도 포함된 작업이라 5번 해줄 필요 없음]
		MultipartRequest mr = new MultipartRequest(
				request, // 기존 요청객체
				path, // 파일이 업로드될 폴더 서버상의 절대경로
				10 * 1024 * 1024, // 허용해줄 파일 최대 크기(용량 제한, 넘기면 exception)
				"euc-kr", // 요청 파라메터 인코딩 방식
				new DefaultFileRenamePolicy() // 파일명 중복 처리됐을 때 어떻게 할 건지 정하는 칸
				);
				// new DefaultFileRenamePolicy() <- 파일 이름이 중복이라면 뒤에 1,2,3... 숫자를 붙여주는 애
				// a.png, a1.png, a2.png ...
		
		// 4-3. 플라스틱 박스를 까야 데이터가 나올 것
		String t = mr.getParameter("title");
		
		// 5. 파일업로드 처리
		
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		pw.print("<form action=\"Upload\" method=\"post\" enctype=\"multipart/form-data\">");
		pw.printf("<h2>%s</h2>",t);
		pw.print("제목 : <input name=\"title\"><br>");
		pw.print("사진 : <input name=\"photo\" type=\"file\"><br>");
		pw.print("<button>등록</button>");
		pw.print("</form>");
		pw.print("</body></html>");
	}
}
