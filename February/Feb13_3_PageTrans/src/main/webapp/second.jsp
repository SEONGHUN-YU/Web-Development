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
		int a = Integer.parseInt(request.getParameter("aa")); 
		int b = Integer.parseInt(request.getParameter("bb")); 
		
		// �ڵ��̵� : ����ڰ� �� �� �ص� �׳� �Ѿ��
		//			second.jsp�� �� ���̰� �ٷ� third.jsp�� ��
		// 1. redirect : �ܼ��� ������ �뵵�θ� �� 
		//			response.sendRedirect("third.jsp");
		// 2. forward : �������� ����(�긦 �ַ����� ��) 
		RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
		
		int c = a + b;
		request.setAttribute("cc", c);
		request.setAttribute("v", 234);
		
		Random r = new Random();
		request.setAttribute("rrr", r);
		
		rd.forward(request, response);
		// 3. include : ���Խ��Ѽ� �������� (frame���� �ذ�����?)
		//			�׷��� ��ġ���� �Ұ� (�׷��� ������ ���� ����), �� ������ ������ include�� ���� ���߿� ��� ��
		//			rd.include(request, response);
		
		// JSP Model 2 - JSP������Ʈ�� MVC���� �����Ų ��
	%>
	<h1>second</h1>
	<%=a %><br>
	<%=b %>
</body>
</html>