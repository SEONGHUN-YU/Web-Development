<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- ����� ȭ������ �� �� ������ -->
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,user-scalable=no">
<!-- <- ����Ͽ� ����ȭ -->
<title>Insert title here</title>
<link rel="stylesheet" href="css\output.css">
</head>
<body>
	<%
	// �� ����Ʈ�� ù ���� = index.html �Ǵ� MainController���� �ϵ���

	// ���� button ������ MainController?v=1�� ��û
	%>
	<table>
		<tr>
			<th colspan="3">����������</th>
		</tr>
		<tr>
			<td align="center" class="subTitle" colspan="3">��
			<td>
		</tr>
		<tr>
			<td align="center" class="rsp"><a href="MainController?v=1"><img
					alt="" src="img\s.jpg"></a></td>
			<td align="center" class="rsp"><a href="MainController?v=2"><img
					alt="" src="img\r.jpg"></a></td>
			<td align="center" class="rsp"><a href="MainController?v=3"><img
					alt="" src="img\p.jpg"></a></td>
		</tr>
		<tr>
			<td align="center" class="subTitle2">��</td>
			<td align="center" class="subTitle2"></td>
			<td align="center" class="subTitle2">��</td>
		</tr>
		<tr>
			<td align="center" class="rsp"><img src="img/${user }"></td>
			<td align="center" class="subTitle2">vs</td>
			<td align="center" class="rsp"><img src="img/${com }"></td>
		</tr>
		<tr>
			<td align="center" colspan="3" class="result">${result }</td>
		</tr>
		<tr>
			<td align="center" colspan="3" class="result">${win }��&nbsp;${draw }��&nbsp;${lose }��</td>
		</tr>
	</table>
</body>
</html>