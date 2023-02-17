<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="calcForm" onsubmit="return calcCheck();" action="CalcController" method="post">
		<textarea id="calcTA" name="calcValue" placeholder="숫자 (엔터로 구분)"></textarea><br>
		<button id="calcBtn">계산</button>
	</form>
</body>
</html>