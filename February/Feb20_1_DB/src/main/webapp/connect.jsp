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
		// DB����Ŀ�� ������, ��Ź���� �� �ٸ���
		// Java ���忡�� �װ� �����ϴ� �� ��� �� �ϳ�
		// => �� ����Ŀ���� �´� ����̹��� �־��
		// => OracleDB�� �����ҰŸ� ojdbc8.jar�� �ְ�
		// OracleDriver od = new ...ó�� ���� ���� �� �ƴϰ�
		// Java�� �˾Ƽ� ���� ���µ�
		Connection con = null;
		try {
			// ����Ŀ���� ����� �޶�
			// �ּҸ� ���� Oracle�̴� �ϰ� �� �� ���� jdbc:oracle
			// �˾Ƽ� OracleDriver�� ���� �� <- �̰� �� Java �� ���
			// JSPȯ�濡���� �˾Ƽ� �� �� : OracleDriver ����� �˷���� ��
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// OracleDriver ��Ű�� ��ɷ� �ҷ��ͼ� import �Ȱ� �����ؼ� forName�� �־���, ª�� �� ���� ��
		String url = "jdbc:oracle:thin:@192.168.0.152:1521:xe"; // Connection URL
		con = DriverManager.getConnection(url, "bigdata", "123456789");
	%>
		<h1>����</h1>
	<%
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
	%>
</body>
</html>