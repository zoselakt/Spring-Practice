<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입성공!</h2>
<label>e-mail</label> : ${customer.email1 } @ ${customer.email2 }<br>
<label>password</label> : ${customer.passwd }<br>
<label>name</label> : ${customer.name }<br>
<label>ssn</label> : ${customer.ssn }<br>
<label>phone</label> : ${customer.phone1 }-${customer.phone2 }-${customer.phone3 }

</body>
</html>