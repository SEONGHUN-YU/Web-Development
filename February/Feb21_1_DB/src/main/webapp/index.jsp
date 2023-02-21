<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/YUValidChecker.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	${result }
	<h1>과자등록</h1>
	<form name="f" onsubmit="return check();" action="SnackController">
	<input name="name" placeholder="이름, 필수" maxlength="10" autofocus="autofocus" autocomplete="off"><br>
	<input name="price" placeholder="가격, 필수" maxlength="5" min="0" autocomplete="off"><br>
	<button>등록</button>
	</form>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
		</tr>	
	<c:forEach var="s" items="${snacks }">
		<tr>
			<td>
				${s.no }
			</td>
			<td>
				${s.name }
			</td>
			<td>
				<fmt:formatNumber value="${s.price }" type="currency" currencySymbol="\\"/>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>