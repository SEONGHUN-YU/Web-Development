<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- 모바일 화면으로 한 번 만들어보자 -->
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,user-scalable=no">
<!-- <- 모바일에 최적화 -->
<title>Insert title here</title>
<link rel="stylesheet" href="css\output.css">
</head>
<body>
	<%
	// 이 사이트의 첫 접속 = index.html 또는 MainController에서 하도록

	// 내기 button 누르면 MainController?v=1로 요청
	%>
	<table>
		<tr>
			<th colspan="3">가위바위보</th>
		</tr>
		<tr>
			<td align="center" class="subTitle" colspan="3">뭐
			<td>
		</tr>
		<tr>
			<td align="center" class="rsp"><a href="MainController?v=1"><img
					alt="" src="img\s.jpg"></a></td>
			<td align="center" class="rsp"><a href="MainController?v=2"><img
					alt="" src="img\r.jpg"></a></td>
			<td align="center" class="rsp"><a href="MainController?v=3"><img
					alt="" src="img\p.jpg"></a></td>
		</tr>
		<tr>
			<td align="center" class="subTitle2">나</td>
			<td align="center" class="subTitle2"></td>
			<td align="center" class="subTitle2">컴</td>
		</tr>
		<tr>
			<td align="center" class="rsp"><img src="img/${user }"></td>
			<td align="center" class="subTitle2">vs</td>
			<td align="center" class="rsp"><img src="img/${com }"></td>
		</tr>
		<tr>
			<td align="center" colspan="3" class="result">${result }</td>
		</tr>
		<tr>
			<td align="center" colspan="3" class="result">${win }승&nbsp;${draw }무&nbsp;${lose }패</td>
		</tr>
	</table>
</body>
</html>