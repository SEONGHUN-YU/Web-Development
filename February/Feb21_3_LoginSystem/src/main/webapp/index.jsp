<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="MemberController" method="post">
		<input name="id" placeholder="ID" autofocus="autofocus" autocomplete="off" value="${cookie.loginID.value }"><br>
		<input name="pw" placeholder="PW" autocomplete="off" type="password"><br>
		<button>로그인</button>
	</form>
</body>
</html>