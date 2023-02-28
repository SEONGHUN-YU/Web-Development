<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<input name="no" value="${notice.no }" type="hidden">	
		<table id="noticeDetailTbl">
			<tr>
				<th colspan="2">
					<input name="title" value="${notice.title }">
				</th>
			</tr>
			<tr>
				<td rowspan="3" align="center" class="imgTd">
					<img src="img/${member.photo }">
				</td>
				<td>
					${member.id }
				</td>
			</tr>
			<tr>
				<td align="right">
					${member.name }
				</td>
			</tr>
			<tr>
				<td align="right">
					<fmt:formatDate value="${notice.date }" type="both" dateStyle="long" timeStyle="short"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<textarea name="txt">${notice.txt }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
						<c:forEach var="r" items="${replys }">
						${r.writer } : ${r.txt } -
						<fmt:formatDate value="${r.date }" type="both" dateStyle="short" timeStyle="short"/><br>
						</c:forEach>
						<hr>
					<%--form action="BBB"--%><%-- form속의 form이라 button방식 불가능 JS로 처리 --%>
						${sessionScope.loginMember.id }
						<input id="token" value="${token }" type="hidden">
						<input id="bn_no" value="${notice.no }" type="hidden">
						<input id="txt" class="replyInput">
						<span onclick="writeNoticeReply();">쓰기</span>
					<%--/form--%>
				</td>
			</tr>
			<c:choose>
				<c:when test="${sessionScope.loginMember.id == member.id }">
					<tr>
						<td colspan="2" align="center">
							<button>수정</button>
			</form>
							<button>삭제</button>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					</form>
				</c:otherwise>
			</c:choose>
		</table>
<%-- 덧글 --%>
</body>
</html>