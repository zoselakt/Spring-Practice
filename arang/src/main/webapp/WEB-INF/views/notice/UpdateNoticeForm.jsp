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
	function gomain() { location.href="notice"};
</script>
	<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/artist/artist_focus.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/gallery/gallery_focus.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/mypage/artwork_upload.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/mypage/gallery_upload.css">
</head>

<body>

<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>

<h1>공지수정</h1>
<form:form method="post" modelAttribute="noticeCommand">
	<table style="align-items: center; justify-content: center;">
		<tr>
			<td>제목</td>
			<td><form:input path="title" class="title" type="text" size="70" maxlength="100" value="${noticeCommand.title}" required=""/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><form:textarea path="content" class="content" cols="72" rows="20" value="${noticeCommand.content}" required=""></form:textarea></td>
		</tr>
		<tr>
			<td><button type="submit" id="location_replace">수정</button></td>
			<td><input type="reset" value="작성취소"></td> 
			<td><input type="button" onclick="gomain()" value="목록으로"></td>
		</tr>
	</table>
</form:form>
</body>
</html>