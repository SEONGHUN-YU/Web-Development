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
	<h1>${xxx }</h1>
	<hr>
	<c:if test="${xxx % 2 == 0 }">
		<h2>¦����</h2> <%-- EL�� �����ڸ� �� �� �ִٴ� ���� �̿��� --%>
	</c:if>
	<hr>
	<c:choose> <%-- else if���� �༮, switch-case�� case���� ������ ���� --%>
		<c:when test="${xxx > 6 }">
			<h2>6���� Ŀ</h2>
		</c:when>
		<c:when test="${xxx > 3 }">
			<h2>4 ~ 6</h2>
		</c:when>
		<c:otherwise> <%-- else�� ���� ����, �� ���ۿ� �� �� --%>
			<h2>4�̸�</h2>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:forEach var="i" begin="1" end="5"> <%-- 1,2,3,4,5 ���� --> <!-- classic for�� ���� --%>
		<h1>��${i }</h1>
	</c:forEach>
	<hr>
	<c:forEach var="s" items="${str }"> <%-- Java�� for-each�� ���� ���� --%>
		<h1>${s }</h1> <%-- s�� var���� �� ���� --%>
	</c:forEach>
	<hr>
	<c:forEach var="i" begin="1" end="20" step="3"> <%-- step �� ���� ++, ���� += step��, --�� -=�� �� �� --%>
		${i }<br>
	</c:forEach>
	<hr>
	${ps }
	<hr>
	${ps[0] } <%-- ��ü�� ���� �ּҰ��� ����, list�� ���� ������ ���� --%>
	<hr>
	${ps[0].name } - ${ps[0].price }��
	<hr>
	<c:forEach var="p" items="${ps }">
		${p.name } : ${p.price }<br>
	</c:forEach>
	<%-- <jsp:include>�� ���߿� java �ҽ��� �ٲ�� �� --%>
	
	<%
	
	// JSTL�� �� ���� �� �ִٸ� : ���� attribute ���
	
	// .jsp(V)���� Java�ҽ� ������
	// ���� �� �ޱ� - EL
	// �������� Ŀ�����±�
	//		<���ξ�:xxx>
	//		ǥ�ؾ׼��±� : include
	//		<jsp:xxx> ���� ������ �� xxx�� ������ ����
	//		����Ŀ�����±�
	//		<c:xxx>		
	//		���ξ ���� ���� �� �ֱ��ѵ� �ҹ����� �־ core�� ���� c��
	//			.jar���� �޾Ƽ� ���� �Ŷ� ���
	//			JSTL(JSP Standard Tag Library)
	//				core : if/for
	//				formatting
	//				functions
	//				...
	%>
</body>
</html>