<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- ����� ȭ������ �� �� ������ -->
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,user-scalable=no"> <!-- <- ����Ͽ� ����ȭ -->
<title>Insert title here</title>
<link rel="stylesheet" href="css\output.css">
<script type="text/javascript" src="js\output.js"></script>
</head>
<body>
	<%
	// �� ����Ʈ�� ù ���� = index.html �Ǵ� MainController���� �ϵ���

	// ���� button ������ MainController?v=1�� ��û
	%>
	<form action="MainController">
		<table>
			<tr>
				<td><img alt="" src="img\s.jpg" onclick="return scissors();"></td>
				<td><img alt="" src="img\r.jpg" onclick="return rock();"></td>
				<td><img alt="" src="img\p.jpg" onclick="return paper();"></td>
			</tr>
			<tr>
				<td>���</td>
			</tr>
		</table>
	</form>
</body>
</html>