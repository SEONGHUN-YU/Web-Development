package com.yu.feb211db.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import seonghun.yu.db.manager.YUDBManager;

public class SnackDAO {
	private static final SnackDAO SNACK = new SnackDAO();

	private SnackDAO() {
	}

	public static SnackDAO getSNACK() {
		return SNACK;
	}

	// 준비물
	// ojdbc?.jar : OracleDB서버랑 연결할 때 필요한 드라이버
	// context.xml : ConnectionPool 설계도
	// kwonDBManager_v2.0.jar : DB연결용 lib(AOP + Java작업)

	// jstl-1.2.jar <- 나중에 필요할 수도?

	public void get(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "select * from feb21_snack order by s_no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // select에서 필요한 거, 실제로 결과가 나와야 하기 때문에 담아주는 것

			ArrayList<Snack> snacks = new ArrayList<>();
			Snack snack = null;
			while (rs.next()) {
				snack = new Snack();
				snack.setNo(rs.getInt("s_no"));
				snack.setName(rs.getString("s_name"));
				snack.setPrice(rs.getInt("s_price"));
				snacks.add(snack);
			}
			req.setAttribute("snacks", snacks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		YUDBManager.world(con, pstmt, rs);
	}

	public void reg(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null; // DB관련작업 총괄 매니저 객체
		try {
			// 연결 먼저 시키고
			con = YUDBManager.hello("DBServer");

			// 데이터 확보
			req.setCharacterEncoding("euc-kr"); // 한글처리
			String n = req.getParameter("name");
			int p = Integer.parseInt(req.getParameter("price"));

			// 세팅
			// SQL (값 들어갈 자리에 ?('도 빼고), ;없애고, 엔터칠 거면 주의)
			String sql = "insert into feb21_snack values(feb21_snack_seq.nextval, ?, ?)";

			// DB관련작업 총괄매니저 객체 만들기
			pstmt = con.prepareStatement(sql);

			// ?에 값 채워서 SQL 완성시키기
			pstmt.setString(1, n);
			pstmt.setInt(2, p);

			// 실행 & 결과처리
			int row = pstmt.executeUpdate(); // 전송
			if (row == 1) {
				req.setAttribute("result", "등록 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록 실패");
		}
		YUDBManager.world(con, pstmt, null);
	}
}
