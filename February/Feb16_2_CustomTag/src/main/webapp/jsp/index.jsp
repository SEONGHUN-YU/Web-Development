<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css\index.css">
<link rel="stylesheet" href="css\calc.css">
<script type="text/javascript" src="js\YUValidChecker.js"></script>
<script type="text/javascript" src="js\feb162check.js"></script>
<!--  
	V���� ���� ���ϵ�[css, js, png, ...] �ҷ��� ���� ����δ�
	index.jsp���� X, Controller ����(webapp�̶� ���� ��ġ�� �����ϸ� ��)
	�ٵ� customTag include�� �ش��ϴ� jsp������ index.jsp���� ��θ� ����� <- �߿�
-->
</head>
<body>
	<table id="site">
		<tr>
			<td id="siteTitle">Feb16</td>
		</tr>
		<tr>
			<td id="siteMenu">
				<!-- 
				get��� �ΰ� �̿��ؼ� ?������=�� ���ְ�
				if������ ������ ��Ȳ�� ������ ó���� ���� ������
				Controller�� ������ ���� �����ϴ� ����� �� ���� 
				-->
				<a href="MainController">Ȩ</a>
				<a href="Menu1Controller">�޴�</a> 
				<a href="CalcController">����</a>
				<a href="BaseballController">���ھ߱�</a>
			</td>
		</tr>
		<tr>
			<td id="siteContent" align="center"><jsp:include
					page="${contentPageHaha }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>