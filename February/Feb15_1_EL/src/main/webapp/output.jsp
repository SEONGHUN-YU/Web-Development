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
		// request.setCharacterEncoding("euc-kr"); // post����� �ѱ� ó�� ���־�� ��, M���� ���־���, �����̳ʰ� �� �ϵ� �ƴϱ� ��
		Human h = (Human) request.getAttribute("dto"); // ��ü�� �� �޴� ��
		
		// JSP Model 2����
		// .jsp�� Java �ҽ� �� ���� ���� ������?
		//		1. �� �������� - EL
		//		2. for, if �� �ʿ��� ���� ���� �� - Ŀ�����±�
		//		3. ����������� (String.format���� ó���ؾ� �� ��) - Ŀ�����±�
		//			EL�� Ŀ�����±� ���� ���� .jsp�� �ҽ� �� �� ����
	%>
	<table>
		<tr>
			<td><h1><%=h.getName()%></h1></td>
		</tr>
		<tr>
			<td><h1><%=h.getBirth()%>��</h1></td>
		</tr>
	</table>
	<hr>
	
	<%
		// EL(Expression Language)
		//		��(parameter, attribute) ���� �� ���
		//		���� : ${???}
		//		�ϴ� EL�� Java�� �ƴ�, Java������ �翬�� �� ��
		//		jsp�� Tomcat�� Servlet���� �ٲ㼭 �����ϴµ�
		//		�� �� Java�ҽ��� �ٲ� <- .jsp������ �ȴٴ� �Ҹ�
		//		���� ������ �׳� �� ���� : Exception �� �� ex) ${param.qweasd} qweasd�� ��� ���� �� ��
		//		������ ��� ����
		//		����ȯ�� �ڵ���
		//		req parameter�� �� : ${param.�Ķ���͸�(input name��)}
		//		req attribute�� ��
		//			�⺻����(int, double, String, ...)  : ${��Ʈ����Ʈ��}
		//			��ü��(Human ���� ��)				: ${��Ʈ����Ʈ��.���������} - getter �־�� ��
		//			��üList(��ü[]�� �Ȱ���)			: ${��Ʈ����Ʈ��[�ε���].���������}
		//	for���� EL�δ� �� ��
		String bd = request.getParameter("bb");
		int a = (Integer) request.getAttribute("a"); // attribute�� ��ü���� ����ȯ
		ArrayList<Human> al = (ArrayList<Human>) request.getAttribute("humans");
	%>
	<h1><%=al.get(0).getName() %></h1>
	<h1><%=al.get(1).getBirth() %></h1>
	<h1>���� : <%=bd %></h1> <!-- Java�� �غ� �� -->
	<h1>a : <%=a %></h1>
	<hr>
	
	<h1>${humans[0].name }</h1>	
	<h1>${humans[1].birth }</h1>	
	<h1>${dto.name }</h1> <!-- ����� ���߿� Tomcat�� getter �Ἥ �ҷ����� ���� getter ����� �� ���� -->
	<h1>${dto.birth }</h1>
	<h1>���� : ${param.bb }</h1>
	<h1>a : ${a }</h1>
	<h1>${param.bb + 10 }</h1>
</body>
</html>