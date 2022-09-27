<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="mainBoard" method="post">
<div id="menu">
	<ul>
		<li><a href="<c:url value="mainBoard"/>"> Home </a></li>
		<li><a href="<c:url value="insertBoard"/>"> 작성 </a></li>
	</ul>
</div>
<table>
	<tr>
		<td>No.</td>
		<td>제목</td>
		<td>작성자</td>
		<td>조회수</td>
		<td>작성일</td>
	</tr>
	<tbody>
		<c:forEach var="board" items="${selectAll}">
			<tr>
				<td>${board.bnum}</td>
				<td><a href="./detailBoard?bnum=${board.bnum}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.readCnt}</td>
				<td>${board.regDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form:form>
</body>
</html>