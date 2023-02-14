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
			<th>결과</th>
		</tr>
		<tr>
			<td align="center"><img src="img\<%=g.getImg()%>" width="100px" height="100px"></td>
		</tr>
		<tr>
			<td align="center">이름 : <%=g.getName()%></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">키 : <%=g.getHeight()%></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">몸무게 : <%=g.getWeight()%><br></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">비만도 : <%=g.getBmi()%><br></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center"><%=g.getResult()%></td>
		</tr>
	</table>
</body>
</html>