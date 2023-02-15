<%@page import="java.util.ArrayList"%>
<%@page import="com.yu.feb151el.main.Human"%>
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
		// request.setCharacterEncoding("euc-kr"); // post방식은 한글 처리 해주어야 함, M에서 해주었음, 디자이너가 할 일도 아니긴 함
		Human h = (Human) request.getAttribute("dto"); // 객체일 때 받는 법
		
		// JSP Model 2에서
		// .jsp에 Java 소스 쓸 일이 뭐가 있을까?
		//		1. 값 받으려면 - EL
		//		2. for, if 등 필요할 일이 있을 것 - 커스텀태그
		//		3. 출력형식지정 (String.format으로 처리해야 할 때) - 커스텀태그
		//			EL과 커스텀태그 쓰면 이제 .jsp에 소스 쓸 일 없다
	%>
	<table>
		<tr>
			<td><h1><%=h.getName()%></h1></td>
		</tr>
		<tr>
			<td><h1><%=h.getBirth()%>살</h1></td>
		</tr>
	</table>
	<hr>
	
	<%
		// EL(Expression Language)
		//		값(parameter, attribute) 받을 때 사용
		//		문법 : ${???}
		//		일단 EL은 Java는 아님, Java에서는 당연히 안 됨
		//		jsp는 Tomcat이 Servlet으로 바꿔서 실행하는데
		//		그 때 Java소스로 바뀜 <- .jsp에서만 된다는 소리
		//		값이 없으면 그냥 안 나옴 : Exception 안 뜸 ex) ${param.qweasd} qweasd가 없어도 에러 안 남
		//		연산자 사용 가능
		//		형변환이 자동임
		//		req parameter일 때 : ${param.파라메터명(input name명)}
		//		req attribute일 때
		//			기본형급(int, double, String, ...)  : ${어트리뷰트명}
		//			객체급(Human 같은 거)				: ${어트리뷰트명.멤버변수명} - getter 있어야 함
		//			객체List(객체[]도 똑같음)			: ${어트리뷰트명[인덱스].멤버변수명}
		//	for문은 EL로는 안 됨
		String bd = request.getParameter("bb");
		int a = (Integer) request.getAttribute("a"); // attribute는 객체여서 형변환
		ArrayList<Human> al = (ArrayList<Human>) request.getAttribute("humans");
	%>
	<h1><%=al.get(0).getName() %></h1>
	<h1><%=al.get(1).getBirth() %></h1>
	<h1>생일 : <%=bd %></h1> <!-- Java로 해본 것 -->
	<h1>a : <%=a %></h1>
	<hr>
	
	<h1>${humans[0].name }</h1>	
	<h1>${humans[1].birth }</h1>	
	<h1>${dto.name }</h1> <!-- 사실은 나중에 Tomcat이 getter 써서 불러오는 거임 getter 지우면 안 나옴 -->
	<h1>${dto.birth }</h1>
	<h1>생일 : ${param.bb }</h1>
	<h1>a : ${a }</h1>
	<h1>${param.bb + 10 }</h1>
</body>
</html>