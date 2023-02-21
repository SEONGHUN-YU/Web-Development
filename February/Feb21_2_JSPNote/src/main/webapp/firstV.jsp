<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function goSecondC() {
		location.href = "SecondC?value=10";
	}
	// js로 post는? -> 불가능
	// js로 지금 없는 <form> 같은 거 만들 수 있음
	// 그걸 이용해서 post로 보낼 수는 있겠으나 결국은 <form>방식이나 마찬가지
</script>
</head>
<body>
	<%--
		request : 사용자가 뭔가를 했을 때 다른 페이지로 이동
			GET방식
				request parameter가 주소에 표기됨
				1. <a href=""></a> : 내용부분을 누르면 출발
				2. JavaScript의 location.href = ""; : 액션을 지정해줄 수 있음
				3. <form action=""> + <button> : 버튼 누르면 출발
				
			POST방식
				request parameter가 내부적으로 처리됨 (주소에 안 나옴)
				1. <form action=""> + <button> : 유일하게 post가 가능한 수단
	--%>

	<h1>firstV</h1>
	<a href="SecondC?value=10">secondV로</a>
	<hr>
	<h2 ondblclick="goSecondC();">secondV로</h2>
	<hr>
	<form action="SecondC">
		<input name="value"><br>
		<button>secondV로</button>
	</form>

</body>
</html>