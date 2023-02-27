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