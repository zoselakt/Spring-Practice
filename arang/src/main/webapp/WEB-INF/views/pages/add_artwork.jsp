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

<form:form method="post" modelAttribute="artwork" enctype="multipart/form-data">
<h3>작품등록 페이지</h3>
<label>작품 카테고리 : </label>
<form:select path="artworkCategory" style="width:170px; text-align:center;">
	<option value="unknown">--선택--</option>
		<form:options items="${phoneProviderList}"/>
</form:select>
<br>
<label>작품이름 : </label><form:input path="artworkName"/>
<br>
<label>작품소개 : </label><form:input path="description"/>
<br>
<label>작품이미지 : </label><form:input path="artworkImg"/>
<br>

</form:form>

작품 카테고리
소개
작품 이미지
작품 id/이미지명
</body>
</html>