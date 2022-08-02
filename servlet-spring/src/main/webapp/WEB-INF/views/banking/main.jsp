<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>안녕하세요!! ${customer.customerid} 님 환영합니다. ${Account.regDate }</h2>
<h3>${customer.customerid } 의 가입 정보</h3>
		<label>아이디: </label>${customer.customerid }<br> <!-- getEmail이 아니라 그냥 email로 해야한다. -->
		<label>비밀번호: </label>${customer.password }<br><!-- 이유는 파라미터에 있는 내용으로 하기 때문이다. -->
		<label>성명: </label>${customer.name}<br>
		<label>주민번호: </label>${customer.ssn }<br>
		<label>전화번호: </label>${customer.phone }<br>
		<label>계좌번호: </label>${account.accountNum }<br>
		<label>계좌타입: </label>${account.accountType }<br>
		<label>현재금액: </label>${account.balance }<br>
		<label>전화번호: </label>${account.interestRate }<br>
			
	<form action="addAccountForm" method="post">
		<input type="submit" value="계좌생성"/>
	</form>
	<form action="logout" method="get">
		<input type="submit" value="로그아웃"/>
	</form>
	<form action="modifyCustomer" method="post">
		<input type="submit" value="계정수정"/>
	</form>
	<form action="deleteCustomer" method="post">
		<input type="submit" value="회원탈퇴"/>
	</form>
</body>
</html>