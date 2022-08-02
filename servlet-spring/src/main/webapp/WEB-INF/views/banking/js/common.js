'use strict'
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
	if(id.value.length < 6 || id.value.length > 14){
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
	if(pw.value.length < 6 || pw.value.length > 18){
		alert("패스워드는 6글자 이상, 18글자 이하입니다.")
		pw.focus();
		return false;
	}
	document.loginForm.submit();
}