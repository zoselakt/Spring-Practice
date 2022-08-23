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
	function gomain() { location.href="notice"}
      function location_replace(){          
		  var link_url = "notice";      
		  location.replace(link_url);
		  document.getElementById("location_replace").innerHTML = link_url;	 
	  }
</script>
</head>
<body>
<h1>공지작성</h1>
<form:form method="post" modelAttribute="noticeCommand">
	<table>
		<tr>
			<td>제목</td>
			<td><form:input path="title" class="title" type="text" size="70" maxlength="100"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input value="${noticeCommand.writer}"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><form:textarea path="content" class="content" cols="72" rows="20"></form:textarea></td>
		</tr>
		<tr>
			<td><button type="submit" id="location_replace">등록</button></td> 
			<td><input type="reset" value="초기화"></td> 
			<td><input type="button" onclick="gomain()" value="목록으로"></td>
		</tr>
	</table>
</form:form>
</body>
</html>