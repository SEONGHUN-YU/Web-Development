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
	// js�� post��? -> �Ұ���
	// js�� ���� ���� <form> ���� �� ���� �� ����
	// �װ� �̿��ؼ� post�� ���� ���� �ְ����� �ᱹ�� <form>����̳� ��������
</script>
</head>
<body>
	<%--
		request : ����ڰ� ������ ���� �� �ٸ� �������� �̵�
			GET���
				request parameter�� �ּҿ� ǥ���
				1. <a href=""></a> : ����κ��� ������ ���
				2. JavaScript�� location.href = ""; : �׼��� �������� �� ����
				3. <form action=""> + <button> : ��ư ������ ���
				
			POST���
				request parameter�� ���������� ó���� (�ּҿ� �� ����)
				1. <form action=""> + <button> : �����ϰ� post�� ������ ����
	--%>

	<h1>firstV</h1>
	<a href="SecondC?value=10">secondV��</a>
	<hr>
	<h2 ondblclick="goSecondC();">secondV��</h2>
	<hr>
	<form action="SecondC">
		<input name="value"><br>
		<button>secondV��</button>
	</form>

</body>
</html>