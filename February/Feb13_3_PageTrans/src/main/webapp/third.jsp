<%@page import="java.util.Random"%>
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
		// request parameter
		//		HTML쪽에서 만들어진 값
		//		String or String[](check박스일 때 한정)
		//		request(요청) 소속
		// request attribute
		//		Java쪽에서 만들어진
		//		Object면 다 됨
		//		request 소속
		
		int a = Integer.parseInt(request.getParameter("aa"));
		int b = Integer.parseInt(request.getParameter("bb"));
		
		Object o = request.getAttribute("cc");
		Integer t = (Integer) o;
		int c = t.intValue();
		
		int v = (Integer) request.getAttribute("v");
		
		Random r = (Random) request.getAttribute("rrr");
		
	%>
	<h1>third</h1>
	<%=a %><br>
	<%=b %><br>
	<%=c %><br>
	<%=v %><br>
	<%=r.nextInt(10) %>
</body>
</html>