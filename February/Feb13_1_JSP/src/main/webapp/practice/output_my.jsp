<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">��ȯ���</h1>
	<%
		request.setCharacterEncoding("euc-kr"); // post��� �� ���� request�� ���־�� �� response�� pass
		
		double num = Double.parseDouble(request.getParameter("changevalue"));
		String result = request.getParameter("changeresult");
		
		if (result.equals("1")) { %>
	
	<h1 align="center">
	<%=num%> cm
	</h1>
	<h1 align="center">��</h1>
	<h1 align="center">
	<%=String.format("%.1f",num * 0.393701) %> inch
	</h1>
	
	<%  }else if (result.equals("2")) { %>

	<h1 align="center">
	<%=num%> ��
	</h1>
	<h1 align="center">��</h1>
	<h1 align="center">
	<%=String.format("%.1f",num * 0.3025) %> ��
	</h1>
			
	<%	}else if (result.equals("3")) { %>
			
	<h1 align="center">
	<%=num%> ��
	</h1>
	<h1 align="center">��</h1>
	<h1 align="center">
	<%=String.format("%.1f",num * 1.8 + 32) %> ��
	</h1>
	
	<%	}else { %>
	
	<h1 align="center">
	<%=num%> km/h
	</h1>
	<h1 align="center">��</h1>
	<h1 align="center">
	<%=String.format("%.1f",num * 0.621371) %> mi/h
	</h1>
	
	<%	} %>

</body>
</html>