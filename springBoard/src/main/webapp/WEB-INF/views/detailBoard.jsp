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
<form:form method="post">
	<table>
		<tr>
			<td>No.</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성글</td>
			<td>조횟수</td>
			<td>작성일</td>
		</tr>
		<tbody>
			<c:forEach var="boardOne" items="${selectOne}">
			<tr>
				<td>${boardOne.bnum}</td>
				<td>${boardOne.title}</td>
				<td>${boardOne.writer}</td>
				<td>${boardOne.content}</td>
				<td>${boardOne.readCnt}</td>
				<td>${boardOne.regDate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		<div class="btn_group2">
	    	<button type="button" onclick="goModify()" class="btn2">수정</button>
	        <button type="button" onclick="goDelete()" class="btn2">삭제</button>
	        <button type="button" onclick="goMain()" class="btn2">목록으로</button>
        </div>
</form:form>

	<script type="text/javascript">
		function goModify() { location.href="updateBoard?bnum=${boardDto.bnum}"}
		function goDelete() { location.href="deleteBoard?bnum=${boardDto.bnum}"}
		function goMain() { location.href="mainBoard"}
	</script>
</body>
</html>