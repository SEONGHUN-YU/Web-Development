<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<script type="text/javascript" src="js/YUValidChecker.js"></script>
<script type="text/javascript" src="js/bpbascpMove.js"></script>
<script type="text/javascript" src="js/bpbascpCheck.js"></script>
</head>
<body>
	<div id="result">${result }</div>
	<table id="siteTitleArea">
		<tr>
			<td align="center" id="siteMenuArea2">
				<table id="siteMenuArea">
					<tr>
						<td>
							<a href="">�޴�1</a>
							<a href="">�޴�2</a>
							<a href="">�޴�3</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center" id="siteTitleArea3">
				<table id="siteTitleArea2">
					<tr>
						<td>
							<a href="HomeController">������ �÷��� ��� AI ���� ���� ������ �缺���� ī��</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteLoginArea">
		<tr>
			<td>
				<jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<jsp:include page="${contentPage }"></jsp:include>
		</tr>
	</table>
</body>
</html>