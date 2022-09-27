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
	function gomain() { location.href="mainBoard"}
</script>
</head>
<body>
	<form:form method="post" modelAttribute="boardDto">
		<table>
			<tr>
				<td>제목</td>
				<td><form:input path="title" class="title" type="text"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><form:input path="writer" class="writer" type="text"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><form:textarea id="content" path="content" class="content" cols="50" rows="50"/></td>
			</tr>
		</table>
		    <div class="btn_group2">
	            <button type="submit" class="btn2">등록</button>
	            <button type="button" onclick="gomain()" class="btn2">취소</button>
            </div>
	</form:form>
</body>
</html>