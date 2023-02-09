package com.yu.feb09vc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
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

		int x = Integer.parseInt(request.getParameter("xx"));
		int y = Integer.parseInt(request.getParameter("yy"));

		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		if (request.getParameter("type").equals("1")) {
			pw.printf("<h1>%d + %d = %d</h1>", x, y, x + y);
		} else if (request.getParameter("type").equals("2")) {
			pw.printf("<h1>%d - %d = %d</h1>", x, y, x - y);
		} else if (request.getParameter("type").equals("3")) {
			pw.printf("<h1>%d * %d = %d</h1>", x, y, x * y);
		} else {
			if (y == 0) {
				pw.print("<h1>0으로는 나눌 수 없어요</h1>");
			} else
				pw.printf("<h1>%d / %d = %d</h1>", x, y, x / y);
		}
		pw.print("</body></html>");
	}

//		int result = x + y;
//		if (request.getParameter("type").equals("2")) {
//			result = x - y;
//		} else if (request.getParameter("type").equals("3")) {
//			result = x * y;
//		} else if (request.getParameter("type").equals("4")) {
//			result = x / y;
//		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 파일 업로드 예제할 때
	// 제목을 굳이 왜 하라고

	// 인코딩 방식이 바뀌었으니
	// 기존 방식으로 값 못 읽음

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("euc-kr");

		// 서버상의 절대경로
		String path = request.getSession().getServletContext().getRealPath("txt");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, 3145728, "euc-kr", new DefaultFileRenamePolicy());

		int x = Integer.parseInt(mr.getParameter("xx"));
		int y = Integer.parseInt(mr.getParameter("yy"));
		String type = mr.getParameter("type");

		String fileName = mr.getFilesystemName("txtFile"); // ㅋ ㅋ3.txt
		fileName = URLEncoder.encode(fileName, "euc-kr"); // %2A+%2A3.txt
		fileName = fileName.replace("+", " "); // %2A %2A.txt
		// tomcat이 한글로 된 파일 파일명 인식 못해
		// fileName = %2A %2A3.txt 같은 상태로 돼 있는 건데 원래대로 돌리자 #1

		int result = x + y;
		if (mr.getParameter("type").equals("2")) {
			result = x - y;
		} else if (mr.getParameter("type").equals("3")) {
			result = x * y;
		} else if (mr.getParameter("type").equals("4")) {
			result = x / y;
		}

		BufferedWriter bw = null;
		try {
			// fileName = %2A %2A3.txt
			// fileName2 = ㅋ ㅋ3.txt
			String fileName2 = URLDecoder.decode(fileName, "euc-kr"); // #1

			FileOutputStream fos = new FileOutputStream(path + "/" + fileName2, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			bw.write(result + "\r\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"EUC-KR\"></head><body>");
		pw.printf("<h1>%d</h1>", result);
		pw.printf("<h1>%s</h1>", fileName);
		pw.printf("<a href=\"txt/%s\">다운받기</a>", fileName);
		pw.print("</body></html>");
	}
}
