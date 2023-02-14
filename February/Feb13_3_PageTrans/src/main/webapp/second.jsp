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
		
		// 자동이동 : 사용자가 뭐 안 해도 그냥 넘어가게
		//			second.jsp는 안 보이고 바로 third.jsp로 감
		// 1. redirect : 단순히 공사중 용도로만 씀 
		//			response.sendRedirect("third.jsp");
		// 2. forward : 정보전달 가능(얘를 주력으로 씀) 
		RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
		
		int c = a + b;
		request.setAttribute("cc", c);
		request.setAttribute("v", 234);
		
		Random r = new Random();
		request.setAttribute("rrr", r);
		
		rd.forward(request, response);
		// 3. include : 포함시켜서 정보전달 (frame문제 해결해줌?)
		//			그러나 위치조절 불가 (그래서 쓸일이 거의 없음), 이 단점을 보완한 include가 있음 나중에 배울 것
		//			rd.include(request, response);
		
		// JSP Model 2 - JSP프로젝트에 MVC패턴 적용시킨 거
	%>
	<h1>second</h1>
	<%=a %><br>
	<%=b %>
</body>
</html>