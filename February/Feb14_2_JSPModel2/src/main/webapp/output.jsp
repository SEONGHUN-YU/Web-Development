<%@page import="com.yu.feb142jm2.main.UCResult"%>
<%@page import="javax.script.ScriptEngine"%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page import="java.util.HashMap"%>
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
		// .jsp(V) : 웹디자이너꺼
		UCResult ucr = (UCResult) request.getAttribute("ucr");
	%>
	<table id="">
		<tr>
			<th>결과</th>
		</tr>
		<tr>
			<td align="center" class="Shadow">
				<%=ucr.getNum() %><%=ucr.getUnit1() %>
			</td>
		</tr>	
		<tr>
			<td align="center">
				↓
			</td>
		</tr>	
		<tr>
			<td align="center" class="Shadow">
				<%=ucr.getResult() %><%=ucr.getUnit2() %>
			</td>
		</tr>	
	</table>
</body>
</html>