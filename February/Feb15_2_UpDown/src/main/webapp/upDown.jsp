<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="MainController">
		<table>
			<tr>
				<td><input name="v" placeholder="1���� 10000�߿� �ϳ��� ������"
					maxlength="5" min="1" max="10000" autofocus="autofocus" autocomplete="off"></td>
			</tr>
			<tr>
				<td>��ݾ� �� : ${param.v }<br>
				</td>
			</tr>
			<tr>
				<td>��� : ${uv }<br>
				</td>
			</tr>
			<tr>
				<td>
					<button>Ȯ��</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>