package com.yu.bpbascp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public static void login(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			req.setCharacterEncoding("euc-kr");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");

			// 전체 다 가져와서 for+if로 상대 - 인터넷 터짐
			// id/pw으로 가져와서 가져와지면 통과 - SQL injection에 털림
			// id로 가져와서 pw는 if로 상대

			String sql = "select * from bpbascp_member where bm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbPW = rs.getString("bm_pw");
				if (pw.equals(dbPW)) {
					// 로그인한 사람의 정보를 (id, 프사, ...)
					// 이 사이트 어디서든 쓸 수 있어야 할테고
					// 보안을 위해 안 쓸 때는 사라져야 할텐데 => 세션!
					Member m = new Member();
					m.setId(id);
					m.setPw(pw);
					m.setName(rs.getString("bm_name"));
					m.setBirthday(rs.getDate("bm_birthday"));
					m.setPhoto(rs.getString("bm_photo"));
					req.getSession().setAttribute("loginMember", m); // 세션+셋어트리뷰트로 세션에 담을 수 있음
					req.getSession().setMaxInactiveInterval(10);
				} else {
					req.setAttribute("result", "로그인 실패 (비밀번호 틀림)");
				}
			} else {
				req.setAttribute("result", "로그인 실패 (미가입 ID)");
			}

//			while (rs.next()) { 
//				보통 select 조회는 while로 하는데 ID는 PK여서 0아님 1이기 때문에
//				if문으로 해도 전혀 상관없고, 무의미한 반복문 사용을 지양하기 위해
//				PW검사는 if문을 사용하도록 하자
//			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "로그인 실패 (DB)");
		}
		YUDBManager.world(con, pstmt, rs);
	}

	// Controller에서 로그인 여부를 체크해야하니
	// 로그인 됐으면 true, 안 됐으면 false
	// loginPage쪽을 로그인 됐으면 member/welcome.jsp로, 안 됐으면 member/login_2btn.jsp로
	public static boolean isLogined(HttpServletRequest req) {
		// 세션+겟어트리뷰트로 세션에 값이
		// 제한시간동안 남아있는지 여부를 판단
		if (req.getSession().getAttribute("loginMember") != null) {
			req.setAttribute("loginPage", "member/welcome.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login_2btn.jsp");
			return false;
		}
	}

	public static void logout(HttpServletRequest req) {
		// 즉시 세션 끊기 (앞으로 작업하다보면 세션에 멤버정보 말고도 넣을 게 많음)
		// req.getSession().setMaxInactiveInterval(-1); <- 그렇게 쓸만한 방법은 아님
		// ↑ 이렇게 하면 모든 게 다 날아가 버림
		req.getSession().setAttribute("loginMember", null);
	}

	public static void bye(HttpServletRequest req) {
		// 지금 로그인된 사람 id 찾아다가 (session에 있을테니)
		// DB에서 delete
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "delete from bpbascp_member where bm_id = ?";
			Member m = (Member) req.getSession().getAttribute("loginMember");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "탈퇴 성공");
				// 파일업로드 : tomcat + cos.jar
				// 파일삭제 : 순수 Java로 File 객체 사용
				// Tomcat(서버)에 들어갈 때 %2A %2A.png처럼 Encoding 되어 있음
				// -> 순수 Java에서 다시 써야해서 ㅋ ㅋ.png로 바꿔줘야 함
				// => 그 때 쓰는 게 URLDecoder.decode(파일명, 형식);
				String folder = req.getSession().getServletContext().getRealPath("img");
				String file = URLDecoder.decode(m.getPhoto(), "euc-kr");
				File f = new File(folder + "/" + file);
				f.delete();
				// 프사 삭제 ★
			} else {
				req.setAttribute("result", "이미 탈퇴된 계정입니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴 실패 (DB)");
		}
		YUDBManager.world(con, pstmt, null);
	}
}
