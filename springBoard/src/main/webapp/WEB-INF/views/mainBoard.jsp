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
	width: 1000px;
	margin: 0 auto;
}
h1{
	text-align: center;
	padding-bottom: 30px;
}
#board-table{
	text-align: center;
	margin: 0 auto;
	display: inline-grid;
}
.title-tbody{
	border-top: 1px solid #000;
	border-bottom: 1px solid #000;
}
.board-tr{
	border: 1px solid #000;
}
.board-tr > td{
	width: 150px;
}
.board-tr > td:nth-child(2) {
	width: 400px;	
}
.inner-tbody{

}
.inner-tr{
	display: block;
	border-bottom: 1px solid #999;
}
.inner-tr > td{
	width: 150px;
}
.inner-tr > td:nth-child(2) {
	width: 400px;	
}
</style>
</head>
<body>
<form:form action="mainBoard" method="post">
<!-- 
<div id="menu">
	<ul>
		<li><a href="<c:url value="mainBoard"/>"> Home </a></li>
		<li><a href="<c:url value="insertBoard"/>"> 작성 </a></li>
	</ul>
</div>
 -->
 <h1>Mybatis Board</h1>
<table id="board-table">
	<tbody class="title-tbody">
		<tr class="board-tr">
			<td>No.</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
	</tbody>
	<tbody class="inner-tbody">
		<c:forEach var="board" items="${selectAll}">
			<tr class="inner-tr">
				<td>${board.bnum}</td>
				<td><a href="./detailBoard?bnum=${board.bnum}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.readCnt}</td>
				<td>${board.regDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	<div class="btn_group2">
	    <button type="button" onclick="goinsert()" class="btn2">등록</button>
    </div>
</form:form>
	<script type="text/javascript">
		function goinsert() { location.href="insertBoard"}
	</script>
</body>
</html>