<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="welcomeTbl">
		<tr>
			<td align="center" rowspan="2" class="imgTd">
				<img src="img/${sessionScope.loginMember.photo }">
			</td>
			<td class="memberTd">
				${sessionScope.loginMember.id }<br>
				${sessionScope.loginMember.name }
			</td>
		</tr>
		<tr>
			<td align="right">
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<button onclick="goMemberInfo();">회원정보</button>
				<button onclick="logout();">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>