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
		<table id="noticeWriteTbl">
			<tr>
				<td align="center">
					<input name="title" placeholder="제목" maxlength="40" autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<textarea name="txt" placeholder="내용" maxlength="250" autocomplete="off"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>쓰기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>