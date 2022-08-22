<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gomain() {location.href="mainForm"	}
</script>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<td>${noticeFindOne.num}</td>
		</tr>
		<tr>		
			<th>제목</th>
			<td>${noticeFindOne.title}</td>
		</tr>	
		<tr>	
			<th>작성자</th>
			<td>${noticeFindOne.writer}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${noticeFindOne.content}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${noticeFindOne.regDate}</td>
		</tr>
	</table>
	<button type="button" onclick="gomain()">메인으로</button>
</body>
</html>