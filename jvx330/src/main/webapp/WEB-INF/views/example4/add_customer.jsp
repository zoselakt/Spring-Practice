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
	<form action="add_customer" method="post">
		<label>Email: </label><input type="text" name="email"><br>
		<label>Password: </label><input type="password" name="password"><br>
		<label>name: </label><input type="text" name="name"><br>
		<label>Ssn: </label><input type="text" name="ssn"><br>
		<label>phone: </label><input type="text" name="phone"><br>
		<input type="submit" value="회원가입"/>
	</form>
</body>
</html>