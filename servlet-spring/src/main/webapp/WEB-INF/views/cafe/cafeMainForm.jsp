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
	<h3>메뉴추가</h3>
	<form:form method="post" modelAttribute="MenuItem">
		<label>menu</label>
		<form:select path="menuItem">
			<form:options itemValue="itemPrice" itemLabel="itemName" items="${cafeItemList }"/>
		</form:select><br>
		<form:input path="menuItemCount"/>
		
		<label>other</label>
		<form:select path="addOther1">
			<form:options items="${otherList }"/>
		</form:select> / 
		<form:select path="addOther2">
			<form:options items="${otherList }"/>
		</form:select><br>
		
		<label>isHot</label>
		<c:if test="${isHot eq 'true'}" >
			<c:out value="hot">hot</c:out>
		</c:if>
		<br>
		
		<input type="submit" value="주문하기"/>
	</form:form>
</body>
</html>