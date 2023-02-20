<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="BookController">
		<input name="book">
		<button>검색</button>
		<hr>
	</form>
	<c:forEach var="s" items="${books }">
		<table align="center" style="float: left;" border="1">
			<tr>
				<td align="center" rowspan="4"><img alt="사진 없음"
					src="${s.thumbnail }"></td>
				<td align="center">${s.title }</td>
			</tr>
			<tr>
				<td align="center">${s.authors }</td>
			</tr>
			<tr>
				<td align="center"><fmt:formatNumber value="${s.price }"
						type="currency" currencySymbol="\\"/></td>
			</tr>
			<tr>
				<td align="center"><fmt:formatDate value="${s.date }"
						type="date" dateStyle="long"/></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>