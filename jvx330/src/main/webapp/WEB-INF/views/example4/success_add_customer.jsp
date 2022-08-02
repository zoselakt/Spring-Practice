<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 성공! </h2>
		<label>Email: </label>${customerCommand.email }<br> <!-- getEmail이 아니라 그냥 email로 해야한다. -->
		<label>Password: </label>${customerCommand.password }<br><!-- 이유는 파라미터에 있는 내용으로 하기 때문이다. -->
		<label>name: </label>${customerCommand.name }<br>
		<label>Ssn: </label>${customerCommand.ssn }<br>
		<label>phone: </label>${customerCommand.phone }<br>
</body>
</html>