package com.yu.bpbascp.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.yu.bpbascp.member.Member;

import seonghun.yu.db.manager.YUDBManager;

public class NoticeDAO {
	private int allNoticeCount;
	private int noticePerPage;

	private static final NoticeDAO NOTICEDAO = new NoticeDAO();

	private NoticeDAO() {
		noticePerPage = 10;
	}

	public static NoticeDAO getNoticeDAO() {
		return NOTICEDAO;
	}

	public void setAllNoticeCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "select count(*) from bpbascp_notice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allNoticeCount = rs.getInt("count(*)");
			System.out.println(allNoticeCount); ///////////////////////////////////////////// 나중에 지울거1
		} catch (Exception e) {
			e.printStackTrace();
		}
		YUDBManager.world(con, pstmt, rs);
	}

	private int getSearchNoticeCount(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "select count(*) from bpbascp_notice where bn_title like '%'||?||'%' or bn_txt like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}

	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	public void search(HttpServletRequest req) {
		req.getSession().setAttribute("search", req.getParameter("search"));
	}

	public void write(HttpServletRequest req) {
		// 새로고침 : 방금 전의 요청 한 번 더 하는 거

		// 글 쓰면 : NoticeWriteController?title=...&txt=...
		// 그러고 나서 새로고침 누르면 : NoticeWriteController?title=...&txt=...
		// 글이 또 써질 수 밖에...

		// 같은 내용으로 글 못 쓰게 막기가 힘듬, 그렇다면 토큰을 써보자
		// 토큰 : 글 쓸 때마다 달라질 거
		// 토큰이 있을 때 글을 쓰면? : NoticeWriteController?title=...&txt=...&token=1
		// 다른 글을 쓰면? : NoticeWriteController?title=...&txt=...&token=2
		// 이 때 새로고침을 하면 : NoticeWriteController?title=...&txt=...&token=2 <- 새로고침해도 같음
		// 이걸 if문으로 처리
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// <textarea>에서 엔터치면 : \r\n
			// 웹페이지에서 줄 바꿈 : <br>
			// 목적에 따라 replace 해주어야 함
			// Java 또는 <textarea>에서 쓸 거면 \r\n인 채로 냅두고
			// 웹페이지에서 쓸거면 \r\n에서 <br>로
			con = YUDBManager.hello("DBServer");

			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("successToken");

			if (lastToken != null && token.equals(lastToken)) { // 새로고침 판별식
				req.setAttribute("result", "글 작성 실패 (새로고침)");
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember"); // 1번 ?자리에 쓰기 위해 세션에서 가져옴

			String sql = "insert into bpbascp_notice values(bpbascp_notice_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, req.getParameter("title"));
			pstmt.setString(3, req.getParameter("txt"));
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "글 작성 성공");
				req.getSession().setAttribute("successToken", token);
				allNoticeCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글 작성 실패 (네트워크 문제)");
		}
		YUDBManager.world(con, pstmt, null);
	}

	public void get(HttpServletRequest req, int page) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");

			int noticeCount = allNoticeCount;
			String search = (String) req.getSession().getAttribute("search");
			if (search == null) { // 전체조회
				search = "";
			} else { // 검색
				noticeCount = getSearchNoticeCount(search);
			}
//			allNoticeCount / noticePerPage; <- 6
//			allNoticeCount / (double) noticePerPage; <- 6.4
//			Math.ceil(allNoticeCount / (double) noticePerPage) <- 7.0
//			(int) Math.ceil(allNoticeCount / (double) noticePerPage) <- 7
			int pageCount = (int) Math.ceil(noticeCount / (double) noticePerPage);
			req.setAttribute("pageCount", pageCount);
			int start = (page - 1) * noticePerPage + 1;
			int end = page * noticePerPage;

			Member m = (Member) req.getSession().getAttribute("loginMember");

//			String sql = "select * from bpbascp_notice order by bn_date desc"; // 전체조회 같은 건 안 쓴다
			String sql = "select * from(select rownum as rn, bn_no, bn_writer, bn_title, bn_date from(select bn_no, bn_writer, bn_title, bn_txt, bn_date from bpbascp_notice where bn_title like '%'||?||'%' or bn_txt like '%'||?||'%' order by bn_date desc)) where rn >= ? and rn <= ?";
			// rownum으로 정렬해줌
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();
			ArrayList<Notice> ns = new ArrayList<>();
			Notice n = null;
			while (rs.next()) {
				n = new Notice();
				n.setNo(rs.getInt("bn_no"));
				n.setWriterID(rs.getString("bn_writer"));
				n.setTitle(rs.getString("bn_title"));
//				n.setTxt(rs.getString("bn_txt")); rownum으로 불러올 때 부담 덜어주려고 뺌
				n.setDate(rs.getDate("bn_date"));
				ns.add(n);
			}
			req.setAttribute("notices", ns);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "조회 실패 (네트워크 문제)");
		}
		YUDBManager.world(con, pstmt, rs);
	}

	public void update(HttpServletRequest req) {
		
	}

	public void delete(HttpServletRequest req) {

	}

	private void getDetailWriter(HttpServletRequest req) { // ID, 이름, 프사
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "select bm_id, bm_name, bm_photo from bpbascp_member where bm_id = (select bn_writer from bpbascp_notice where bn_no = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(req.getParameter("bn")));
			rs = pstmt.executeQuery();
			rs.next();
			Member m = new Member();
			m.setId(rs.getString("bm_id"));
			m.setName(rs.getString("bm_name"));
			m.setPhoto(rs.getString("bm_photo"));
			req.setAttribute("member", m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		YUDBManager.world(con, pstmt, rs);
	}

	public boolean getDetail(HttpServletRequest req) { // 글 번호, 제목, 내용, 날짜
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "select bn_no, bn_title, bn_txt, bn_date from bpbascp_notice where bn_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(req.getParameter("bn")));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				getDetailWriter(req); // join 사용을 피하기 위해 2개의 method로 나눠서 작업 (subquery를 써도 되긴 하지만 이런 방식도 가능)
				Notice n = new Notice();
				n.setNo(Integer.parseInt(req.getParameter("bn")));
				n.setTitle(rs.getString("bn_title"));
				n.setTxt(rs.getString("bn_txt"));
				n.setDate(rs.getDate("bn_date"));
				req.setAttribute("notice", n);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}
}
