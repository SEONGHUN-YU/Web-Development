<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="joinForm" onsubmit="return regCheck();" action="JoinController" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td align="center">
					회원가입
				</td>
			</tr>
			<tr>
				<td align="center">
					ID : <input name="id" placeholder="필수, 최대10자 한글x" autofocus="autofocus" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					PW : <input name="pw" placeholder="필수, 최대10자 확인, 조합" type="password" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					확인 : <input name="pwchk" placeholder="필수, 최대10자 확인, 조합" type="password" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					이름 : <input name="name" placeholder="필수, 최대10자" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					생일
				</td>
			</tr>
			<tr>
				<td align="center">
					<select name="year">
						<c:forEach var="y" begin="${cy - 100 }" end="${cy }">
							<option>${y }</option>
						</c:forEach>
					</select>년
					<select name="month">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
					</select>월
					<select name="day">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
					</select>일<br>
				</td>
			</tr>
			<%--input name="birthday" placeholder="생년월일 8자리 ex)20230101" maxlength="8"><br --%>
			<tr>
				<td align="center">
					프사
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="photo" type="file" placeholder="필수, 사진만" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>가입</button><br>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>