package com.yu.feb28ds.coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import seonghun.yu.db.manager.YUDBManager;

// 제공자 입장 : 작업 끝
// 사용자 입장 : 파싱 어떡하라고? 한글 처리는?

// 제공자/사용자 사이에 데이터 형식에 대한 약속이 있어야 할 것
// => 그래야 파싱을 할테니
// => 국제 표준이 있음
//		데이터를 HTML 모양으로 하자 <- XML (eXtended Markup Language), 데이터를 HTML DOM객체 모양으로 표현가능 (내맘대로)
//		어차피 JavaScript에서 쓸 거면서 뭐하려고 HTML 모양으로 해?
//		그럴거면 데이터를 JS모양으로 하자 <- JSON
// AJAX <- JS로 XML파싱 - 외부데이터는 불가
public class CoffeeDAO {

	// 웹사이트랑은 상관없는 외부인에게 데이터 주고 싶은데 뭐를 써야 하지?
	// => 쓸 게 없다, 저 4개는 전부 웹사이트 내부에서만 사용할 수 있는 것들이기 때문
	// rquest parameter : 화살표
	// rquest attribute : 화살표
	// session attribute : 서버-클 연결
	// cookie : 클 컴퓨터 하드
	public static String getCoffee(HttpServletRequest req) { // String으로 만들어서 외부로 보내줄 거임
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "select * from feb28_coffee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// String 대량으로 붙일 때
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

			sb.append("<feb28_coffee>");
			while (rs.next()) {
				sb.append("<coffee>");

				sb.append("<name>");
				sb.append(rs.getString("c_name"));
				sb.append("</name>");

				sb.append("<price>");
				sb.append(rs.getInt("c_price"));
				sb.append("</price>");

				sb.append("</coffee>");
			}
			sb.append("</feb28_coffee>");

			return sb.toString();
		} catch (Exception e) {
			return null;
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}

	public static String getCoffeeJSON(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "select * from feb28_coffee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			StringBuffer sb = new StringBuffer();
			sb.append("[");
			boolean first = true;
			while (rs.next()) {
				if (first) {
					first = false;
				} else {
					sb.append(",");
				}
				sb.append("{");

				sb.append("\"name\"");
				sb.append(":\"" + rs.getString("c_name") + "\",");

				sb.append("\"price\"");
				sb.append(":" + rs.getInt("c_price"));

				sb.append("}");
			}
			sb.append("]");
			return sb.toString();

//			rs.next();
//			while (true) {
//				sb.append("{");
//
//				sb.append("\"name\"");
//				sb.append(":\"" + rs.getString("c_name") + "\",");
//
//				sb.append("\"price\"");
//				sb.append(":" + rs.getInt("c_price"));
//
//				sb.append("}");
//				if (rs.next()) {
//					sb.append(",");
//				} else {
//					break;
//				}
//			}
		} catch (Exception e) {
			return null;
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}

	public static void show(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello("DBServer");
			String sql = "select * from feb28_coffee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Coffee> coffees = new ArrayList<>();
			while (rs.next()) {
				coffees.add(new Coffee(rs.getString("c_name"), rs.getInt("c_price")));
			}
			// 웹사이트랑은 상관없는 외부인에게 데이터 주고 싶은데 뭐를 써야 하지?
			// => 쓸 게 없다, 저 4개는 전부 내부에서만 사용할 수 있는 것들이기 때문
			// rquest parameter : 화살표
			// rquest attribute : 화살표
			// session attribute : 서버-클 연결
			// cookie : 클 컴퓨터 하드
			req.setAttribute("coffees", coffees);
		} catch (Exception e) {
			e.printStackTrace();
		}
		YUDBManager.world(con, pstmt, rs);
	}
}
