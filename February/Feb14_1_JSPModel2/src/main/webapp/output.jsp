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
		int z = (Integer) request.getAttribute("zv");
	%>
	<h1>계산결과</h1>
	<%=z %>
</body>
</html>