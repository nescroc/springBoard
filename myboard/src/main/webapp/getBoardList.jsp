<%@page import="java.util.List"%>
<%@page import="sen.spring.web.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.board.list.mainTitle"/></title>
</head>
<body>
	<h1><spring:message code="message.board.list.mainTitle"/></h1>
	<h3>
		${userName} <spring:message code="message.board.list.welcomeMsg"/>&nbsp;&nbsp;&nbsp;<a href="logout.do">logout</a>
	</h3>
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post">
		<table border="1">
			<tr>
				<td>
				<select name="searchCondition">
					<c:forEach items="${conditionMap }" var="option">
					<option value="${option.value }">${option.key}</option>
					</c:forEach>
				</select> 
				<input type="text" name="searchKeyword">
				<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"></td>
			</tr>
		</table>
	</form>
	<br>
	<!-- 검색 종료 -->
	<table border="1">
		<tr>
			<th><spring:message code="message.board.list.table.head.seq"/></th>
			<th><spring:message code="message.board.list.table.head.title"/></th>
			<th><spring:message code="message.board.list.table.head.writer"/></th>
			<th><spring:message code="message.board.list.table.head.regDate"/></th>
			<th><spring:message code="message.board.list.table.head.cnt"/></th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.seq }</td>
				<td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
				<td>${board.writer}</td>
				<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
</body>
</html>