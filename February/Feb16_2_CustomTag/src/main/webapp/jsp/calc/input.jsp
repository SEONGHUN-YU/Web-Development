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
		<h1>����</h1>
		x : <input name="xx" placeholder="���ڸ�" autofocus="autofocus"
			autocomplete="off"><br> y : <input name="yy"
			placeholder="���ڸ�" autocomplete="off"><br>
		<button id="calcBtn">���</button>
	</form>
</body>
</html>