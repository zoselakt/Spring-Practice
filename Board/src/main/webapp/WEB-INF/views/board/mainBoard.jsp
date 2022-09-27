<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goinsert() { location.href="insertBoard"}
</script>
</head>
<body>
	<form:form method="post" modelAttribute="boardDto">
		<table>
			<c:forEach var="board" items="${boardDto}">
			<tr>
				<td>제목</td>
				<td>${board.title}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${board.content }</td>
			</tr>
			</c:forEach>
		</table>
	        <button type="button" class="btn2" onclick="goinsert()">글 작성</button>
	</form:form>
</body>
</html>