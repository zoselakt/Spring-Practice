<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>정보수정</h2>
	<form action="modifyCustomer" method="post">
		<label>아이디: </label>${customer.customerid }<br>
		<label>성명: </label><input type="text" name="name"><br>
		<label>주민번호: </label><input type="text" name="ssn"><br>
		<label>전화번호: </label><input type="text" name="phone"><br>
		<input type="submit" value="정보수정"/>
	</form>
</body>
</html>