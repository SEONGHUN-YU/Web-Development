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
					ȸ������
				</td>
			</tr>
			<tr>
				<td align="center">
					ID : <input name="id" placeholder="�ʼ�, �ִ�10�� �ѱ�x" autofocus="autofocus" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					PW : <input name="pw" placeholder="�ʼ�, �ִ�10�� Ȯ��, ����" type="password" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					Ȯ�� : <input name="pwchk" placeholder="�ʼ�, �ִ�10�� Ȯ��, ����" type="password" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					�̸� : <input name="name" placeholder="�ʼ�, �ִ�10��" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					����
				</td>
			</tr>
			<tr>
				<td align="center">
					<select name="year">
						<c:forEach var="y" begin="${cy - 100 }" end="${cy }">
							<option>${y }</option>
						</c:forEach>
					</select>��
					<select name="month">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
					</select>��
					<select name="day">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
					</select>��<br>
				</td>
			</tr>
			<%--input name="birthday" placeholder="������� 8�ڸ� ex)20230101" maxlength="8"><br --%>
			<tr>
				<td align="center">
					����
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="photo" type="file" placeholder="�ʼ�, ������" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>����</button><br>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>