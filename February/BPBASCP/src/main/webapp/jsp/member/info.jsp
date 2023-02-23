<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- 비번, 프사 수정 가능하게 --%>
		<table id="memberInfoTbl">
	<form action="">
			<tr>
				<th>${sessionScope.loginMember.id }(${sessionScope.loginMember.name })</th>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" class="boxType" value="${sessionScope.loginMember.pw }" maxlength="10" placeholder="pw(숫자포함)" type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pwChk" class="boxType" value="${sessionScope.loginMember.pw }" maxlength="10" placeholder="pw확인" type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<br>
					<fmt:formatDate value="${sessionScope.loginMember.birthday }" type="date" dateStyle="long"/>생
				</td>
			</tr>
			<tr>
				<td align="center">
					<img src="img/${sessionScope.loginMember.photo }"><br>
					<input type="file" name="photo">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>정보수정</button>
	</form>
					<button onclick="bye();">탈퇴</button>
				</td>
			</tr>
		</table>
</body>
</html>