<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goinsert() {	location.href = "InsertNoticeForm";}
	function goupdate() {	location.href = "UpdateNoticeForm";}
	function godelete() {	location.href = "DeleteNoticeForm";}
	function gofindAll() {	location.href = "FindAllNoticeForm";}
	function gofindOne() {	location.href = "FindOneNoticeForm";}
</script>
</head>
<body>
	<button type="button" onclick="goinsert()" name="insert_Notice">글작성</button>
	<button type="button" onclick="goupdate()" name="update_Notice">글수정</button>
	<button type="button" onclick="godelete()" name="delete_Notice">글삭제</button>
	<button type="button" onclick="gofindAll()" name="findAll_Notice">글전체조회</button>
	<button type="button" onclick="gofindOne()" name="findOne_Notice">글하나조회</button>
</body>
</html>