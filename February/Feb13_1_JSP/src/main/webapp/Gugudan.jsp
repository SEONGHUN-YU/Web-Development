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
			<th><%=dan %>단</th>
		</tr>
		<%for (int i = 1; i < 10; i++) { %>
		<tr>
		<td><%=dan%> * <%=i%> = <%=dan * i%></td> <!-- 코드를 Java로 짜, HTML 기본문법에 해당하는 건 print에 넣을 필요가 없다 -->
		</tr>
		<%} %>
	</table>
</body>
</html>