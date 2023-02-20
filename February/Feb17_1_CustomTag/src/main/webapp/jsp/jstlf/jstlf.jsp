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
		// .jsp���� Java�ҽ� ������
		// 1. �� �ޱ� - EL
		// 2. ���ǹ�/�ݺ��� - JSTL-core
		// 3. ������� - JSTL-formatting ���̺귯���� ����
		// �Ҽ��� ��°�ڸ������� �ش޶� = String.format
		// ��¥ ���� ������ �ش޶� = SimpleDateFormat
	%>
	<h1>${aaa }</h1>
	<hr>
	<fmt:formatNumber value="${aaa }" type="number"/>
	<hr>
	<fmt:formatNumber value="${aaa }" type="currency" currencySymbol="\\"/> <%-- ��ȭó�� --%>
	<%-- 
		���� : ������ ���������� ���� �´� ��ȣ�� �˾Ƽ� ����µ�
		���� : ... �� ���ش�
	--%>
	<hr>
	<fmt:formatNumber value="${bbb }" type="percent"/> <%-- *100 �ؼ� % �ٿ��ش� --%>
	<hr>
	<fmt:formatNumber value="${bbb }" pattern="#.000"/> <%-- �Ҽ��� ���ϸ� 0������ŭ ���� --%>
	<%--
		# : ������ ������ ������ �� ������
		0 : �� �ڸ��� ������ ì��� (������ 0�� �־�� ì��)
	--%>
	<hr>
	<fmt:formatNumber value="${ccc }" pattern="000000.000"/> <%-- EL�̶� String <-> int �ڵ� ����ȯ --%>
	<hr>
	<%-- ����ε� Date��ü�� ���� �� ���� String �Ұ��� --%>
	<fmt:formatDate value="${eee }" type="date" dateStyle="short"/>
	<hr>
	<fmt:formatDate value="${eee }" type="time" timeStyle="long"/>
	<hr>
	<fmt:formatDate value="${eee }" type="both" dateStyle="long" timeStyle="short"/>
	<hr>
	<fmt:formatDate value="${eee }" pattern="MM dd E"/> <%-- ���� �� ����� --%>
	<hr>
</body>
</html>