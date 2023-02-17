<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	입력페이지
	<form name="testForm" onsubmit="return testCheck();"
		action="TestController">
		<input name="yeah"><br>
		<button id="testBtn">확인</button>
	</form>
</body>
</html>