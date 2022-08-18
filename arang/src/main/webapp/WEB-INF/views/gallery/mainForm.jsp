<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goinsert() {	location.href = "InsertGalleryForm";}
	function goupdate() {	location.href = "UpdateGalleryForm";}
	function godelete() {	location.href = "DeleteGalleryForm";}
	function gofindAll() {	location.href = "FindAllGalleryForm";}
	function gofindOne() {	location.href = "FindOneGalleryForm";}
	function gofileupload() {	location.href = "FileUploadForm";}
</script>
</head>
<body>
	<button type="button" onclick="goinsert()" name="insert_gallery">갤러리추가</button>
	<button type="button" onclick="goupdate()" name="update_gallery">갤러리수정</button>
	<button type="button" onclick="godelete()" name="delete_gallery">갤러리삭제</button>
	<button type="button" onclick="gofindAll()" name="findAll_gallery">갤러리모두찾기</button>
	<button type="button" onclick="gofindOne()" name="findOne_gallery">갤러리하나찾기</button>
	<button type="button" onclick="gofileupload()" name="File_Upload">파일업로드폼</button>
</body>
</html>