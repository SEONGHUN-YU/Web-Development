<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css\input.css">
</head>
<body>
	<table>
		<tr>
			<th>���</th>
		</tr>
		<tr>
			<td align="center"><img src="img/${gg.img }" width="100px" height="100px"></td>
		</tr>
		<tr>
			<td align="center">�̸� : ${gg.name }</td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">Ű : ${gg.height }</td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">������ : ${gg.weight }<br></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">�񸸵� : ${gg.bmi }<br></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center">${gg.result }</td>
		</tr>
	</table>
</body>
</html>