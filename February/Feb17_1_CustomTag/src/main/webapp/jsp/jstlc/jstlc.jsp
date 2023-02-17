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
		<h2>짝수다</h2> <%-- EL이 연산자를 쓸 수 있다는 것을 이용함 --%>
	</c:if>
	<hr>
	<c:choose> <%-- else if같은 녀석, switch-case의 case같은 느낌도 있음 --%>
		<c:when test="${xxx > 6 }">
			<h2>6보다 커</h2>
		</c:when>
		<c:when test="${xxx > 3 }">
			<h2>4 ~ 6</h2>
		</c:when>
		<c:otherwise> <%-- else랑 완전 같음, 한 번밖에 못 씀 --%>
			<h2>4미만</h2>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:forEach var="i" begin="1" end="5"> <%-- 1,2,3,4,5 까지 --> <!-- classic for문 느낌 --%>
		<h1>ㅋ${i }</h1>
	</c:forEach>
	<hr>
	<c:forEach var="s" items="${str }"> <%-- Java의 for-each문 같은 느낌 --%>
		<h1>${s }</h1> <%-- s는 var에서 온 거임 --%>
	</c:forEach>
	<hr>
	<c:forEach var="i" begin="1" end="20" step="3"> <%-- step 안 쓰면 ++, 쓰면 += step값, --나 -=는 안 됨 --%>
		${i }<br>
	</c:forEach>
	<hr>
	${ps }
	<hr>
	${ps[0] } <%-- 객체일 때는 주소값만 나옴, list일 때는 값으로 나옴 --%>
	<hr>
	${ps[0].name } - ${ps[0].price }원
	<hr>
	<c:forEach var="p" items="${ps }">
		${p.name } : ${p.price }<br>
	</c:forEach>
	<%-- <jsp:include>는 나중에 java 소스로 바뀌는 애 --%>
	
	<%
	
	// JSTL로 뭐 만든 게 있다면 : 전부 attribute 취급
	
	// .jsp(V)에서 Java소스 없애자
	// 각종 값 받기 - EL
	// 나머지는 커스텀태그
	//		<접두어:xxx>
	//		표준액션태그 : include
	//		<jsp:xxx> 같은 식으로 씀 xxx가 정해져 있음
	//		사제커스텀태그
	//		<c:xxx>		
	//		접두어를 내가 정할 수 있긴한데 불문율이 있어서 core일 때는 c로
	//			.jar파일 받아서 쓰는 거랑 비슷
	//			JSTL(JSP Standard Tag Library)
	//				core : if/for
	//				formatting
	//				functions
	//				...
	%>
</body>
</html>