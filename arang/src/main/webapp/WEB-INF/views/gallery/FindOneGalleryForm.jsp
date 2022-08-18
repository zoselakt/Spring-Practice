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
	function gomain() {	location.href = "mainForm";}
</script>
</head>
<body>
	<ul>
		<img src="/resources/img/img${galleryFindOne.code}.jpg">
		<li>갤러리 코드 : ${galleryFindOne.code}</li>
		<a href="#"><li>갤러리 이름 : ${galleryFindOne.galleryName}</li></a><!-- 클릭하면 갤러리 홈페이지로 이동 -->
			<li>갤러리 소유자 : ${galleryFindOne.galleristName}</li>
			<li>갤러리 주소 : ${galleryFindOne.address}</li>
			<li>갤러리 이메일 : ${galleryFindOne.galleryEmail}</li>
			<li>갤러리 전화번호 : ${galleryFindOne.galleryPhone}</li>
			<li>갤러리 큐모 : ${galleryFindOne.area}</li>
			<li>갤러리 금액 : ${galleryFindOne.payment}</li>
			<li>갤러리 층수 : ${galleryFindOne.galleryFloor}</li>
			<li>협력사코드 : ${galleryFindOne.corporateRegistrationNum}</li>
	</ul>
	<button type="button" onclick="gomain()">메인으로</button>
</body>
</html>