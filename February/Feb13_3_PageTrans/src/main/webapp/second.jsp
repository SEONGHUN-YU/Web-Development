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
		//		HTML�ʿ��� ������� ��
		//		String or String[](check�ڽ��� �� ����)
		//		request(��û) �Ҽ�
		int a = Integer.parseInt(request.getParameter("aa")); 
		int b = Integer.parseInt(request.getParameter("bb")); 
	%>
	<h1>second</h1>
	<%=a %><br>
	<%=b %>
</body>
</html>