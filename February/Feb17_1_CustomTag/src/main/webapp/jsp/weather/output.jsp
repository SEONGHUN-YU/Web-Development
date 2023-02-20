<%@page import="com.yu.feb171ct.weather.Weather"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>날씨</h1>
	<%
	// DAO에서 DTO를 attribute로 보내주는 중
	// ArrayList<Weather> ws = (ArrayList<Weather>) request.getAttribute("ws");
	%>
	<c:forEach var="s" items="${ws }">
		<table border="1" style="float: left;">
			<tr>
				<td colspan="2" align="center">
					<h1>시간 : ${s.hour }</h1>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h1>기온 : ${s.temp }</h1>
					<h1>날씨 : ${s.wfKor }</h1>
					<img alt="" src="img/weather/${s.img }">
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>