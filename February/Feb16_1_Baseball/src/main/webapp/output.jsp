<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/output.css">
<script type="text/javascript" src="js\YUValidChecker.js"></script>
<script type="text/javascript" src="js\output.js"></script>
</head>
<body>
	<form name="f" onsubmit="return check();" action="MainController">
		<table>
			<tr>
				<th>���ھ߱�</th>
			</tr>
			<tr>
				<td><input name="v" placeholder="���� 3�ڸ�" maxlength="3"
					min="100" max="999" autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>${i }ȸ ${b }�� ${s }��Ʈ����ũ ${c }������ ����</td>
			</tr>
			<tr>
				<td>
					<button>�����ϱ�</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>