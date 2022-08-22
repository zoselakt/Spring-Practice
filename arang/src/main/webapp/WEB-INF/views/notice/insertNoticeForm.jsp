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
	function gomain() { location.href="notice"}
</script>
</head>
<body>
<h1>공지작성</h1>
<form:form method="post" modelAttribute="noticeCommand">
	<table>
		<tr>
			<td>제목</td>
			<td><form:input path="title" class="title" type="text" size="70" maxlength="100"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><form:input path="writer" class="writer" type="text" placeholder="임의의 작성자값"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><form:textarea path="content" class="content" cols="72" rows="20"></form:textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="등록하기"></td>
			<td><input type="reset" value="작성취소"></td> 
			<td><input type="button" onclick="gomain()" value="목록으로"></td>
		</tr>
	</table>
</form:form>
</body>
</html>