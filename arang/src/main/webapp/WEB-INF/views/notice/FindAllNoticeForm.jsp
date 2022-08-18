<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function gomain() { location.href="mainForm"}
function selChange() {
	var sel = document.getElementById('pageCount').value;
	location.href="FindAllNoticeForm?currentPage=${PagingVo.currentPage}&pageCount="+sel;
}
</script>
</head>
<body>
<form:form method="get" modelAttribute="noticeFindAll">
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${pagingVo.pageCount == 5}">selected</c:if>>5줄 보기</option>
			<option value="10"
				<c:if test="${pagingVo.pageCount == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${pagingVo.pageCount == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${pagingVo.pageCount == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div> <!-- 옵션선택 끝 -->
	<table>
		<tr>
			<th>공지 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조횟수</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="noticeFindAll" items="${noticeFindAll}">
		<tr>
			<td>${noticeFindAll.num}</td>
			<td><a href="./FindOneNoticeForm?num=${noticeFindAll.num}">${noticeFindAll.title}</a></td>
			<td>${noticeFindAll.num}</td> 
			<td>${noticeFindAll.writer}</td>
			<td>${noticeFindAll.readCnt}</td>
			<td>${noticeFindAll.regDate}</td>
			<td><a href="./UpdateNoticeForm?num=${noticeFindAll.num}">글 수정</a></td>
			<td><a href="./DeleteNoticeForm?num=${noticeFindAll.num}">글 삭제</a></td>
		</tr>
		</c:forEach>
		
	</table>
	<button type="button" onclick="gomain()">메인으로</button>
	
	<div style="display: block; text-align: center;">		
		<c:if test="${pagingVo.startPage != 1 }">
			<a href="FindAllNoticeForm?currentPage=${pagingVo.startPage - 1}&currentPage=${pagingVo.pageCount}">&lt;</a>
		</c:if>
		<c:forEach begin="${pagingVo.startPage}" end="${pagingVo.endPage}" var="page">
			<c:choose>
				<c:when test="${page == pagingVo.currentPage}">
					<b>${page}</b>
				</c:when>
				<c:when test="${page != pagingVo.currentPage }">
					<a href="FindAllNoticeForm?currentPage=${page}&currentPage=${pagingVo.pageCount}">${page}</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${pagingVo.endPage != pagingVo.endBlock}">
			<a href="FindAllNoticeForm?currentPage=${pagingVo.endPage + 1}&currentPage=${pagingVo.pageCount}">&gt;</a>
		</c:if>
	</div>
</form:form>
</body>
</html>