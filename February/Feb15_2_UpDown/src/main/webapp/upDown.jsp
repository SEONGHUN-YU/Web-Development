<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="MainController">
		<table>
			<tr>
				<td><input name="v" placeholder="1부터 10000중에 하나를 쓰세요"
					maxlength="5" min="1" max="10000" autofocus="autofocus" autocomplete="off"></td>
			</tr>
			<tr>
				<td>방금쓴 답 : ${param.v }<br>
				</td>
			</tr>
			<tr>
				<td>결과 : ${uv }<br>
				</td>
			</tr>
			<tr>
				<td>
					<button>확인</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>