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
	V에서 쓰는 파일들[css, js, png, ...] 불러올 때의 상대경로는
	index.jsp기준 X, Controller 기준(webapp이랑 같은 위치라 생각하면 됨)
	근데 customTag include에 해당하는 jsp파일은 index.jsp기준 경로를 써야함 <- 중요
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
				get방식 인걸 이용해서 ?변수명=값 해주고
				if문으로 값마다 상황을 나눠서 처리할 수도 있지만
				Controller를 여러개 만들어서 제어하는 방법이 더 낫다 
				-->
				<a href="MainController">홈</a>
				<a href="Menu1Controller">메뉴</a> 
				<a href="CalcController">덧셈</a>
				<a href="BaseballController">숫자야구</a>
			</td>
		</tr>
		<tr>
			<td id="siteContent" align="center"><jsp:include
					page="${contentPageHaha }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>