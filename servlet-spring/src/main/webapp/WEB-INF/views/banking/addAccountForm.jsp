<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gomain() {
		location.href = "banking/main";
	}
</script>
</head>
<body>
	<h2>계좌생성</h2>
	<p>본인정보확인</p>
	<form action="addAccountForm" method="post">
		<label>성명: </label>${customer.name }<br>
		<label>주민번호: </label>${customer.ssn }<br>
		<label>계좌번호: </label><input type="text" name="accountNum"><br>
		<label>계좌타입: </label><input type="text" name="accountType"><br>
		<input type="submit" value="계좌생성" onclick="gomain()"/>
	</form>
</body>
</html>