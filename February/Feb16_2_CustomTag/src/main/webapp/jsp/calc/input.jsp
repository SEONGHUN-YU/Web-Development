<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="calcForm" onsubmit="return calcCheck();" action="CalcController">
		<h1>덧셈</h1>
		x : <input name="xx" placeholder="숫자만" autofocus="autofocus"
			autocomplete="off"><br> y : <input name="yy"
			placeholder="숫자만" autocomplete="off"><br>
		<button id="calcBtn">계산</button>
	</form>
</body>
</html>