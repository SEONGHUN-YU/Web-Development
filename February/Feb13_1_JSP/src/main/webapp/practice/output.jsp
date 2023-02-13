<%@page import="javax.script.ScriptEngine"%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="..\css\index.css">
<%!
	private String changeUnit(double num){
		return String.format("%.1f", num);
	}
%>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr"); // post��� �� ���� request�� ���־�� �� response�� pass
		
		HashMap<String, String[]> hm = new HashMap<>();
		hm.put("len", new String[] {"cm", "inch"});
		hm.put("size", new String[] {"��", "��"});
		hm.put("temp", new String[] {"��", "��"});
		hm.put("spd", new String[] {"km/h", "mi/h"});
		
		double num = Double.parseDouble(request.getParameter("changevalue"));
		String result = request.getParameter("changeresult");
		double changedValue = 0;
		if (result.equals("len")) {
			changedValue = num * 0.393701;
		}else if(result.equals("size")) {
			changedValue = num * 0.3025;
		}else if(result.equals("temp")) {
			changedValue = num * 1.8 + 32;
		}else {
			changedValue = num * 0.621371;
		}
		
		/* String sik = num + " * 0.621371"; .eval()�� ����ؼ� ǥ���� �� �ִٰ� �� �ϴ� fail
		
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("JavaScript");
		double last = (Double) se.eval(sik); */
		
		response.sendRedirect("..\\test.html");
	%>
	<table id="<%=result %>">
		<tr>
			<th>���</th>
		</tr>
		<tr>
			<td align="center" class="<%=result %>Shadow">
				<%=changeUnit(num) %> <%=hm.get(result)[0] %>
			</td>
		</tr>	
		<tr>
			<td align="center">
				��
			</td>
		</tr>	
		<tr>
			<td align="center" class="<%=result %>Shadow">
				<%=changeUnit(changedValue) %> <%=hm.get(result)[1] %>
			</td>
		</tr>	
	</table>
</body>
</html>