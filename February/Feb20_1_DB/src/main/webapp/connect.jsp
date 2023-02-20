<%@page import="oracle.jdbc.driver.OracleDriver"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%	
		// DB메이커가 많은데, 통신방식이 다 다른데
		// Java 입장에서 그거 연결하는 걸 어떻게 다 하나
		// => 각 메이커별로 맞는 드라이버가 있어야
		// => OracleDB랑 연결할거면 ojdbc8.jar를 넣고
		// OracleDriver od = new ...처럼 만들어서 쓰는 게 아니고
		// Java가 알아서 만들어서 쓰는데
		Connection con = null;
		try {
			// 메이커별로 양식이 달라서
			// 주소만 봐도 Oracle이다 하고 알 수 있음 jdbc:oracle
			// 알아서 OracleDriver를 만들어서 씀 <- 이건 쌩 Java 때 얘기
			// JSP환경에서는 알아서 못 함 : OracleDriver 쓰라고 알려줘야 함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// OracleDriver 패키지 긴걸로 불러와서 import 된거 복사해서 forName에 넣어줌, 짧은 건 옛날 거
		String url = "jdbc:oracle:thin:@192.168.0.152:1521:xe"; // Connection URL
		con = DriverManager.getConnection(url, "bigdata", "123456789");
	%>
		<h1>성공</h1>
	<%
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
	%>
</body>
</html>