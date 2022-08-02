<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h2>@RequestMapping을 통한 경로맵핑</h2>
	<h2>Result : ${result}</h2>
	
	<form action="" method="post">
		<input type="checkbox" name="agree"/> 약관동의
		<input type="submit" value="확인"/>
	</form>
</body>
</html>