<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function loginjs(){
	var special = /^[a-zA-Z0-9]{4,12}$/;
	var special2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	var id = document.getElementById("customerid");
	var pw = document.getElementById("password");
	
	if(id.value == "" || id.value == null){
		alert("아이디를 입력해 주세요");
		id.focus();
		return false;
	}
	if(!id.value){
		alert("아이디가 틀립니다.");
		id.focus();
		return false;
	}
	if(id.value.trim().length < 1){
		alert("공백은 사용할수 없습니다.")
		id.focus();
		return false;
	}
	if(id.value.length < 6 && id.value.length > 14){
		alert("아이디는 6글자 이상, 14글자 이하입니다.")
		pw.focus();
		return false;
	}
	
	if(pw.value == "" || pw.value == null){
		alert("비밀번호를 입력해 주세요");
		password.focus();
		return false;
	}
	if(!pw.value){
		alert("비밀번호가 틀립니다.");
		password.focus();
		return false;
	}
	if(pw.value == id.value){
		alert("비밀번호는 아이디와 같으면 안됩니다.")
		password.focus();
		return false;
	}
	if(pw.value.trim().length < 1){
		alert("공백은 사용할수 없습니다.")
		pw.focus();
		return false;
	}
	if(pw.value.length < 6 && pw.value.length > 18){
		alert("패스워드는 6글자 이상, 18글자 이하입니다.")
		pw.focus();
		return false;
	}
	document.loginForm.submit();
}
</script>
</head>
<body>
	<h2>로그인</h2>
	<form action="main" method="post" name="loginForm">
		<label>아이디: </label><input type="text" id="customerid" name="customerid"><br>
		<label>비밀번호: </label><input type="password" id="password" name="password"><br>
		<input type="button" value="로그인" onclick="loginjs()"/>
		<input type="reset" value="취소"/>
	</form>
		<h2>확인</h2>
		<label>아이디: </label>${customer.customerid }<br> <!-- getEmail이 아니라 그냥 email로 해야한다. -->
		<label>비밀번호: </label>${customer.password }<br><!-- 이유는 파라미터에 있는 내용으로 하기 때문이다. -->
		<label>성명: </label>${customer.name }<br>
		<label>주민번호: </label>${customer.ssn }<br>
		<label>전화번호: </label>${customer.phone }<br>
		<label>계좌번호: </label>${account.accountNum }<br>
		<label>계좌타입: </label>${account.accountType }<br>
		<label>현재금액: </label>${account.balance }<br>
		<label>전화번호: </label>${account.interestRate }<br>

</body>
</html>
