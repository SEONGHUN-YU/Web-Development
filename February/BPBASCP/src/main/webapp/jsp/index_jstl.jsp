<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
	// HTML, CSS, JavaScript의 공통점 : Interpreter방식 <- error 찾기가 힘듬
	// JavaScript는 main이 없었음
	// JavaScript에서 main역할 하는 함수가 가지고 싶음
	// HTML DOM객체들 다 나오고 나서, 실행되도록
	function showAlert(r){
		// Java에서, char c = 'a'; / String s = "aa";
		// JS는 '랑 "를 구분하지 않음
		alert(r);
	}
</script>
</head>
<c:choose>
	<c:when test="${result == null }"> <%-- 이렇게도 구현할 수 있긴한데 실전성은 음... --%>
		<body>
	</c:when>
	<c:otherwise>
		<body onload="showAlert('${result}');"> <%-- JavaScript에서 main역할을 할 수 있게 해준 것 --%>
	</c:otherwise>
</c:choose>
	<div id="result">${result }</div>
	<table id="siteTitleArea">
		<tr>
			<td align="center" id="siteMenuArea2">
				<table id="siteMenuArea">
					<tr>
						<td>
							<a href="">메뉴1</a>
							<a href="">메뉴2</a>
							<a href="">메뉴3</a>
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
							<a href="HomeController">빅데이터 플랫폼 기반 AI 융합 서비스 개발자 양성과정 카페</a>
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