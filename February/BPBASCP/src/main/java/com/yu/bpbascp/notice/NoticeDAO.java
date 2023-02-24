package com.yu.bpbascp.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.yu.bpbascp.member.Member;

import seonghun.yu.db.manager.YUDBManager;

public class NoticeDAO {
	private static final NoticeDAO NOTICEDAO = new NoticeDAO();

	private NoticeDAO() {
	}

	public static NoticeDAO getNoticeDAO() {
		return NOTICEDAO;
	}

	public void write(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// <textarea>에서 엔터치면 : \r\n
			// 웹페이지에서 줄 바꿈 : <br>
			// 목적에 따라 replace 해주어야 함
			// Java 또는 <textarea>에서 쓸 거면 \r\n인 채로 냅두고
			// 웹페이지에서 쓸거면 \r\n에서 <br>로
			con = YUDBManager.hello("DBServer");

			Member m = (Member) req.getSession().getAttribute("loginMember"); // 1번 ?자리에 쓰기 위해 세션에서 가져옴

			String sql = "insert into bpbascp_notice values(bpbascp_notice_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, req.getParameter("title"));
			pstmt.setString(3, req.getParameter("txt"));
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글 작성 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글 작성 실패 (네트워크 문제)");
		}
		YUDBManager.world(con, pstmt, null);
	}

	public void get(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");

			Member m = (Member) req.getSession().getAttribute("loginMember");

			String sql = "select * from bpbascp_notice order by bn_date desc";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Notice> ns = new ArrayList<>();
			Notice n = null;
			while (rs.next()) {
				n = new Notice();
				n.setNo(rs.getInt("bn_no"));
				n.setWriterID(rs.getString("bn_writer"));
				n.setTitle(rs.getString("bn_title"));
				n.setTxt(rs.getString("bn_txt"));
				n.setDate(rs.getDate("bn_date"));
				ns.add(n);
			}
			req.setAttribute("notices", ns);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "조회 실패 (네트워크 문제)");
		}
	}
}
