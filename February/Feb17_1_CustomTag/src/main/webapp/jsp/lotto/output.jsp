<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- for문 좀 어떻게... -->
	<c:forEach var="l" items="${lottoResult }">
		<img alt="" src="${l }">
	</c:forEach>
	<br>
	
	<img alt="" src="${lottoResult[0] }">
	<img alt="" src="${lottoResult[1] }">
	<img alt="" src="${lottoResult[2] }">
	<img alt="" src="${lottoResult[3] }">
	<img alt="" src="${lottoResult[4] }">
	<img alt="" src="${lottoResult[5] }">
</body>
</html>