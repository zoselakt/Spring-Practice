<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h2>회원가입</h2>
	<form action="addCustomerForm" method="post">
		<label>아이디: </label><input type="text" name="customerid"><br>
		<label>비밀번호: </label><input type="password" name="password"><br>
		<label>성명: </label><input type="text" name="name"><br>
		<label>주민번호: </label><input type="text" name="ssn"><br>
		<label>전화번호: </label><input type="text" name="phone"><br>
		<input type="submit" value="회원가입"/>
	</form>
</body>
</html>