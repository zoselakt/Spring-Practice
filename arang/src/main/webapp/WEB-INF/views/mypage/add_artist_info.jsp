<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value ='/resources/css/default.css'/>"/>
</head>
<body>
${email}님 안녕하세요
<br>
<h3>아티스트 페이지 등록</h3>
<form action="add_artist_info" method="post" enctype="multipart/form-data">
<label>아티스트 title : </label><input type="textarea" name="title" style="width: 200px; height: 100px;"/>
<br>
<label>아티스트 description : </label><input type="textarea" name="description" style="width: 500px; height: 500px;"/>
<br>
<label>아티스트 img : </label><input type="file" name="imgFile"/>
<br>
<input type="submit" value="등록"/>
</form>
</body>
</html>