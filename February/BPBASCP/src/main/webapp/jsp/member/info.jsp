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
	<%-- ���, ���� ���� �����ϰ� --%>
		<table id="memberInfoTbl">
	<form action="">
			<tr>
				<th>${sessionScope.loginMember.id }(${sessionScope.loginMember.name })</th>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" class="boxType" value="${sessionScope.loginMember.pw }" maxlength="10" placeholder="pw(��������)" type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pwChk" class="boxType" value="${sessionScope.loginMember.pw }" maxlength="10" placeholder="pwȮ��" type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<br>
					<fmt:formatDate value="${sessionScope.loginMember.birthday }" type="date" dateStyle="long"/>��
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
					<button>��������</button>
	</form>
					<button onclick="bye();">Ż��</button>
				</td>
			</tr>
		</table>
</body>
</html>