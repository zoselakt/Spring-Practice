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
<form:form method="post" modelAttribute="boardDto">
		<table>
			<c:forEach var="update" items="${selectOne}">
			<tr>
				<td>제목</td>
				<td><form:input path="title" class="title" type="text" size="100" value="${update.title}"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><form:input path="writer" class="title" type="text" size="100" value="${update.writer}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" id="content" class="content" cols="100" rows="50">${update.content}</textarea></td>
			</tr>
			</c:forEach>
		</table>
		    <div class="btn_group2">
	            <button type="submit" class="btn2">수정</button>
	            <button type="button" onclick="gomain()" class="btn2">취소</button>
            </div>
	</form:form>
	
	<script type="text/javascript">
		function gomain() { location.href="mainBoard"}
	</script>
</body>
</html>