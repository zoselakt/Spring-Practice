<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원탈퇴</h2>
	<form action="deleteCustomer" method="post">
		<h2>본인 정보 확인</h2>
		<label>아이디: </label>${customer.customerid }<br>
		<label>비밀번호: </label>${customer.password }<br>
		<label>성명: </label>${customer.name }<br>
		<label>주민번호: </label>${customer.ssn }<br>
		<label>전화번호: </label>${customer.phone }<br>
		<label>계좌번호: </label>${account.accountNum }<br>
		<label>계좌타입: </label>${account.accountType }<br>
		<label>현재금액: </label>${account.balance }<br>
		<label>전화번호: </label>${account.interestRate }<br>
		<input type="submit" value="회원탈퇴">
	</form>
</body>
</html>