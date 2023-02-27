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
	<table id="noticeBBSArea" border="1">
		<tr>
			<td align="right">
				<a href="NoticeWriteController">글쓰러 가기</a>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="noticeBBS">
						<tr>
							<th class="th1">제목</th>
							<th class="th2">글쓴이</th>
							<th>날짜</th>
						</tr>
					<c:forEach var="s" items="${notices }">
						<tr class="dataTr" onclick="goNoticeDetail(${s.no});">
							<td>
								${s.title }
							</td>
							<td align="center">
								${s.writerID }
							</td>
							<td align="center">
								<fmt:formatDate value="${s.date }" type="date" dateStyle="short"/>
							</td>					
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="NoticePageController?p=${p }">${p }</a>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center" id="noticeSearchArea">
				<form action="NoticeSearchController">
					<input name="search" maxlength="30" autocomplete="off">
					<button>검색</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>