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
		int dan = Integer.parseInt(request.getParameter("aa"));
	%>
	<table border="1">
		<tr>
			<th><%=dan %>��</th>
		</tr>
		<%for (int i = 1; i < 10; i++) { %>
		<tr>
		<td><%=dan%> * <%=i%> = <%=dan * i%></td> <!-- �ڵ带 Java�� ¥, HTML �⺻������ �ش��ϴ� �� print�� ���� �ʿ䰡 ���� -->
		</tr>
		<%} %>
	</table>
</body>
</html>