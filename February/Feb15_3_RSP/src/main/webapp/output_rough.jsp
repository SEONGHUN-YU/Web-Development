<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- 모바일 화면으로 한 번 만들어보자 -->
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,user-scalable=no"> <!-- <- 모바일에 최적화 -->
<title>Insert title here</title>
<link rel="stylesheet" href="css\output.css">
<script type="text/javascript" src="js\output.js"></script>
</head>
<body>
	<%
	// 이 사이트의 첫 접속 = index.html 또는 MainController에서 하도록

	// 내기 button 누르면 MainController?v=1로 요청
	%>
	<form action="MainController">
		<table>
			<tr>
				<td><img alt="" src="img\s.jpg" onclick="return scissors();"></td>
				<td><img alt="" src="img\r.jpg" onclick="return rock();"></td>
				<td><img alt="" src="img\p.jpg" onclick="return paper();"></td>
			</tr>
			<tr>
				<td>결과</td>
			</tr>
		</table>
	</form>
</body>
</html>