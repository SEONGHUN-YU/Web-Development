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
		int a = Integer.parseInt(request.getParameter("aa")); 
		int b = Integer.parseInt(request.getParameter("bb")); 
	%>
	<h1>second</h1>
	<%=a %><br>
	<%=b %>
</body>
</html>