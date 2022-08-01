<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form:form method="post" modelAttribute="customer">
		<label>e-mail</label>
		<form:input path="email1"/>@
		<form:select path="email2">
			<form:options itemValue="emailHost" itemLabel="emailCode" items="${emailProviderList }"/>
		</form:select><br>
		<label>password</label>
		<form:input path="passwd"/><br>
		<label>name</label>
		<form:input path="name"/><br>
		<label>ssn</label>
		<form:input path="ssn"/><br>
		<label>phone1</label>
		<form:select path="phone1">
			<form:options items="${phoneProviderList }"/>
		</form:select>
		<form:input path="phone2"/> - <form:input path="phone3"/>
		<br><br>
		<input type="submit" value="가입하기"/>
	</form:form>
</body>
</html>