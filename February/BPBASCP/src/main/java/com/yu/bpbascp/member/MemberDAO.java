package com.yu.bpbascp.member;

import java.io.File;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import seonghun.yu.db.manager.YUDBManager;

// singleton패턴 아니어도 됨
public class MemberDAO {
	public static void join(HttpServletRequest req) {
		// 유효성 검사를 해서 오지만, 파일용량은 검사 못 했음
		// 10MB 넘는 사진파일을 올리면 -> 실패할텐데 -> DB작업하지말자
		// 프사 필수인데 -> 프사 등록이 안 됐으니 -> 가입불가
		// 상대경로 -> 서버상의 절대경로로 바꿔줌 ↓
		String path = req.getSession().getServletContext().getRealPath("img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패 (파일 문제)");
			// 프사 파일 업로드가 실패했음 (파일 용량때문에)
			// DB작업을 할 필요가 없음
			return; // 이 method 종료
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello("DBServer");

			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
//		String pwchk = mr.getParameter("pwchk"); // 이건 유효성 검사용인데 굳이 같은 걸 2개 가져올 필요는 없다, 빼야 함
			String name = mr.getParameter("name");

			String year = mr.getParameter("year");
			String month = mr.getParameter("month");
			String day = mr.getParameter("day");
			String birthday = String.format("%s%02d%02d", year, Integer.parseInt(month), Integer.parseInt(day));

			String photo = URLEncoder.encode(mr.getFilesystemName("photo"), "euc-kr").replace("+", " ");

			String sql = "insert into bpbascp_member values(?, ?, ?, to_date(?, 'YYYYMMDD'), ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, birthday);
			pstmt.setString(5, photo);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "가입 성공");
				System.out.println("등록 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패 (네트워크 문제)");
			// DB서버쪽 문제로 실패 했을 때 걸림
			// 프사 업로드는 성공했고, DB서버쪽 문제로 가입 실패하는 상황
			// => 아까 성공했던 그 파일 지워야 함

			// 파일업로드 : JSP + cos.jar로
			// 파일삭제 : 쌩 Java로
			File f = new File(path + "/" + mr.getFilesystemName("photo")); // 쌩 Java여서 한글처리 안 해도 됨
			f.delete();
			// 한글처리는 Tomcat을 위해서 하는 거임
		}
		YUDBManager.world(con, pstmt, null);
	}
}
