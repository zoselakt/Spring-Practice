<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
	text-decoration: none;
}
form#command{
	text-align: center;
	width: 1000px;
	margin: 0 auto;
}
#board-table{
	display: inline-grid;
	width: 600px;
	border: 1px solid #000; 
}
.title-tbody{
	width: inherit;
	border-bottom: 1px solid #000;
	text-align: center;
	display: inline-flex;
	justify-content: space-around;
}
.title-tr{
	display: inline-grid;
	width: 100%;
	height: 60px;
}
.title-tr:nth-child(2){
	border-left: 1px solid #000;
    border-right: 1px solid #000;
}
.inner-tbody{
	width: inherit;
	text-align: center;
}
.inner-tr{
	display: inline-grid;
	width: 100%;
}
.inner-tr:nth-child(1) {
	border-bottom: 1px solid #000;
	height: 60px;
}
.inner-tr > td:nth-child(2) {
	height: 400px;
}
</style>
</head>
<body>
<form:form method="post">
	<h1>Mybatis Board</h1>
	<table id="board-table">
		<c:forEach var="boardOne" items="${selectOne}">
			<tbody class="title-tbody">
				<tr class="title-tr">
					<td>No.</td>
					<td>${boardOne.bnum}</td>
				</tr>
				<tr class="title-tr">
					<td>작성자</td>
					<td>${boardOne.writer}</td>
				</tr>
				<tr class="title-tr">
					<td>작성일</td>
					<td>${boardOne.regDate}</td>
				</tr>
			</tbody>
			<tbody class="inner-tbody">
				<tr class="inner-tr">
					<td>제목</td>
					<td>${boardOne.title}</td>
				</tr>
				<tr class="inner-tr">
					<td>작성글</td>
					<td>${boardOne.content}</td>
				</tr>
			</tbody>
		</c:forEach>
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