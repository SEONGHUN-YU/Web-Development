<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function go(){
		location.href = "second.jsp?aa=10&bb=5"; // 2번째 스타일
	}
</script>
</head>
<body>
	<%
		// request - 수동이동(뭔가 액션을 취하면 이동)
		// 1. <a> : GET방식요청 - 클릭하면 출발
		// 2. JavaScript : GET방식요청 (location.href = "";) - 이벤트(액션을 on시리즈로) 선택 가능
		// 3. <form> + <button> : GET/POST 방식요청(유일하게 POST방식 가능) - 클릭하면 출발
		//		3.은 입력받은 걸로 주소 만들어서 자동요청해주는 시스템
	%>
	<h1>first</h1>
	<a href="second.jsp?aa=7&bb=9">second로</a>
	<hr>
	<div ondblclick="go();">second로</div>
	<hr>
	<form action="second.jsp" method="post">
		a : <input name="aa"><br> <!-- 3번째 스타일 -->
		b : <input name="bb"><br>
		<button>second로</button>
	</form>	
</body>
</html>