<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// JSP Model 2 구조를 취했는데도
		//	.jsp에 Java 소스를 쓸 일이 뭐가 있을까?
		// 1. V에서 만들어진 거(parameter)
		//	  M에서 작업해준 거(attribute)
		//	  를 읽긴 읽어야 하니까 -> EL
		// 2. 조건문, 반복문
		// 3. 출력형식지정 <- String.format 같은 거 어떡하게?
		
		// customTag <- 종류가 2가지
		//		프로그램쪽 기능들을 DOM객체형태로 만들 수 있다면?
		//		디자이너를 위해 for문을 <for></for> 같은 느낌으로
		//		EL과 마찬가지로 JSP가 Servlet으로 바뀔 때 Java 소스로 바뀜
		//		-> .jsp에서만 쓸 수 있다는 소리
		
		//		<접두어:XXX>
		//		정품 - JSP표준액션태그
		//			JSP환경에서 기본적으로 사용 가능함
		//			접두어로 jsp를 씀
		//		사제품 - 기타커스텀태그
		
		// redirect - 기타커스텀태그 쪽에 있음
		// response.sendRedirect("test.jsp"); <- 공사중 용도, 이건 커스텀태그에 없음
		
		// test2.jsp로 포워딩이 하고 싶음 (해당 페이지로 바로 가도록)
		// forward
		// request.getRequestDispatcher("test2.jsp").forward(request, response);
		
		// 흥미로운데 찬밥 취급 - Java로 쓸 경우 위치 조절이 안 됨
		// include <- 현재 이 페이지가 포워드하는 페이지에 포함되는 포워드 같은 느낌
		// request.getRequestDispatcher("test2.jsp").include(request, response);
	%>
	<h1>test</h1>
	<hr>
	<!-- 정확한 작동원리는 test2.jsp에 있는 소스 그대로 여기에 추가하는 것 -->
	<!-- interpreter여서 그냥 넘어가는 거지 사실 문법상으론 잘못되긴 함 -->
	<jsp:include page="test2.jsp"></jsp:include> <!-- 위치 조절이 가능 -->
	
	<!-- MVC할 거고, 여기는 V라서 사실 디자이너에게 커스텀태그 기능 거의 필요없음 -->
	
</body>
</html>