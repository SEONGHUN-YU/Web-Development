<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Feb17</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/test.css">
<link rel="stylesheet" href="css/calc.css">
<script type="text/javascript" src="js/YUValidChecker.js"></script>
<script type="text/javascript" src="js/feb171check.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td id="siteTitleArea2" align="center">
				<table id="siteTitle">
					<tr>
						<td>
							<a href="HomeController">Feb17</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td id="siteMenuArea" align="center">
				<table id="siteMenu">
					<tr>
						<td>
							<a href="TestController">����</a>
							<a href="CalcController">�� ���ϱ�</a>
							<a href="LottoController">�ζ� ��ȣ �ڵ���÷</a>
							<a href="JSTLCController">JSTL-core</a>
							<a href="WeatherController">���û ����</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center">
				<jsp:include page="${cp }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>