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
		// JSP Model 2 ������ ���ߴµ���
		//	.jsp�� Java �ҽ��� �� ���� ���� ������?
		// 1. V���� ������� ��(parameter)
		//	  M���� �۾����� ��(attribute)
		//	  �� �б� �о�� �ϴϱ� -> EL
		// 2. ���ǹ�, �ݺ���
		// 3. ����������� <- String.format ���� �� ��ϰ�?
		
		// customTag <- ������ 2����
		//		���α׷��� ��ɵ��� DOM��ü���·� ���� �� �ִٸ�?
		//		�����̳ʸ� ���� for���� <for></for> ���� ��������
		//		EL�� ���������� JSP�� Servlet���� �ٲ� �� Java �ҽ��� �ٲ�
		//		-> .jsp������ �� �� �ִٴ� �Ҹ�
		
		//		<���ξ�:XXX>
		//		��ǰ - JSPǥ�ؾ׼��±�
		//			JSPȯ�濡�� �⺻������ ��� ������
		//			���ξ�� jsp�� ��
		//		����ǰ - ��ŸĿ�����±�
		
		// redirect - ��ŸĿ�����±� �ʿ� ����
		// response.sendRedirect("test.jsp"); <- ������ �뵵, �̰� Ŀ�����±׿� ����
		
		// test2.jsp�� �������� �ϰ� ���� (�ش� �������� �ٷ� ������)
		// forward
		// request.getRequestDispatcher("test2.jsp").forward(request, response);
		
		// ��̷ο ���� ��� - Java�� �� ��� ��ġ ������ �� ��
		// include <- ���� �� �������� �������ϴ� �������� ���ԵǴ� ������ ���� ����
		// request.getRequestDispatcher("test2.jsp").include(request, response);
	%>
	<h1>test</h1>
	<hr>
	<!-- ��Ȯ�� �۵������� test2.jsp�� �ִ� �ҽ� �״�� ���⿡ �߰��ϴ� �� -->
	<!-- interpreter���� �׳� �Ѿ�� ���� ��� ���������� �߸��Ǳ� �� -->
	<jsp:include page="test2.jsp"></jsp:include> <!-- ��ġ ������ ���� -->
	
	<!-- MVC�� �Ű�, ����� V�� ��� �����̳ʿ��� Ŀ�����±� ��� ���� �ʿ���� -->
	
</body>
</html>