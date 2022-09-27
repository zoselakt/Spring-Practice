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
	<div class="btn_group2">
		<button type="submit" class="btn2">삭제</button>
	    <button type="button" onclick="gomain()" class="btn2">취소</button>
    </div>
	</form:form>
	
	<script type="text/javascript">
		function gomain() { location.href="mainBoard"}
	</script>
</body>
</html>