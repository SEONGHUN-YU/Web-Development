<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function go(){
		location.href = "second.jsp?aa=10&bb=5"; // 2��° ��Ÿ��
	}
</script>
</head>
<body>
	<%
		// request - �����̵�(���� �׼��� ���ϸ� �̵�)
		// 1. <a> : GET��Ŀ�û - Ŭ���ϸ� ���
		// 2. JavaScript : GET��Ŀ�û (location.href = "";) - �̺�Ʈ(�׼��� on�ø����) ���� ����
		// 3. <form> + <button> : GET/POST ��Ŀ�û(�����ϰ� POST��� ����) - Ŭ���ϸ� ���
		//		3.�� �Է¹��� �ɷ� �ּ� ���� �ڵ���û���ִ� �ý���
	%>
	<h1>first</h1>
	<a href="second.jsp?aa=7&bb=9">second��</a>
	<hr>
	<div ondblclick="go();">second��</div>
	<hr>
	<form action="second.jsp" method="post">
		a : <input name="aa"><br> <!-- 3��° ��Ÿ�� -->
		b : <input name="bb"><br>
		<button>second��</button>
	</form>	
</body>
</html>