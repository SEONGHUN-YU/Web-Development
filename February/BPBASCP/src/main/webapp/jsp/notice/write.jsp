<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="noticeWriteForm" onsubmit="return noticeWriteCheck();" action="NoticeWriteController">
		<%-- input name="token" value="${token }" readonly="readonly" --%>
		<input name="token" value="${token }" type="hidden">
		<table id="noticeWriteTbl">
			<tr>
				<td align="center">
					<input name="title" placeholder="����" maxlength="40" autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<textarea name="txt" placeholder="����" maxlength="250" autocomplete="off"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>����</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>