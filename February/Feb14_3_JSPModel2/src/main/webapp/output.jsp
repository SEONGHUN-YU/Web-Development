<%@page import="com.yu.feb143jm2.main.Guest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css\input.css">
</head>
<body>
	<%
	Guest g = (Guest) request.getAttribute("gg");
	%>
	<table>
		<tr>
			<th>���</th>
		</tr>
		<tr>
			<td align="center"><img src="img\<%=g.getImg()%>" width="100px" height="100px"></td>
		</tr>
		<tr>
			<td align="center">�̸� : <%=g.getName()%></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">Ű : <%=g.getHeight()%></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">������ : <%=g.getWeight()%><br></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">�񸸵� : <%=g.getBmi()%><br></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center"><%=g.getResult()%></td>
		</tr>
	</table>
</body>
</html>