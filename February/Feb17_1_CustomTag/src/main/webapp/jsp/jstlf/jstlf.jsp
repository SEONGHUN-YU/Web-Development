<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// .jsp에서 Java소스 없애자
		// 1. 값 받기 - EL
		// 2. 조건문/반복문 - JSTL-core
		// 3. 출력형식 - JSTL-formatting 라이브러리에 있음
		// 소수점 둘째자리까지만 해달라 = String.format
		// 날짜 요일 나오게 해달라 = SimpleDateFormat
	%>
	<h1>${aaa }</h1>
	<hr>
	<fmt:formatNumber value="${aaa }" type="number"/>
	<hr>
	<fmt:formatNumber value="${aaa }" type="currency" currencySymbol="\\"/> <%-- 원화처리 --%>
	<%-- 
		예전 : 브라우저 국가설정에 따라서 맞는 기호를 알아서 써줬는데
		요즘 : ... 안 해준다
	--%>
	<hr>
	<fmt:formatNumber value="${bbb }" type="percent"/> <%-- *100 해서 % 붙여준다 --%>
	<hr>
	<fmt:formatNumber value="${bbb }" pattern="#.000"/> <%-- 소숫점 이하만 0갯수만큼 나옴 --%>
	<%--
		# : 있으면 나오고 없으면 안 나오고
		0 : 그 자리는 무조건 챙긴다 (없으면 0을 넣어서라도 챙김)
	--%>
	<hr>
	<fmt:formatNumber value="${ccc }" pattern="000000.000"/> <%-- EL이라 String <-> int 자동 형변환 --%>
	<hr>
	<%-- 제대로된 Date객체만 받을 수 있음 String 불가능 --%>
	<fmt:formatDate value="${eee }" type="date" dateStyle="short"/>
	<hr>
	<fmt:formatDate value="${eee }" type="time" timeStyle="long"/>
	<hr>
	<fmt:formatDate value="${eee }" type="both" dateStyle="long" timeStyle="short"/>
	<hr>
	<fmt:formatDate value="${eee }" pattern="MM dd E"/> <%-- 형식 내 맘대로 --%>
	<hr>
</body>
</html>