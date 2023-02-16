<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css\baseball.css">
</head>
<body>
	<form name="baseballForm" onsubmit="return baseballCheck();" action="BaseballController" method="post">
		<table>
			<tr>
				<th>숫자야구</th>
			</tr>
			<tr>
				<td><input name="user" placeholder="숫자 3자리" maxlength="3"
					min="100" max="999" autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>${i }회 ${b }볼 ${s }스트라이크 ${c }번만에 성공</td>
			</tr>
			<tr>
				<td>
					<button>판정하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>