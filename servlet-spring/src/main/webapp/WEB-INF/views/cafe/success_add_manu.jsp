<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>주문성공!</h2>
<label>menu</label> : ${MenuItem.menuItem } / ${MenuItem.menuItemCount }<br>
<label>other</label> : ${MenuItem.addOther1} + ${MenuItem.addOther2}<br>
<label>isHot</label> : ${MenuItem.isHot }<br>
</body>
</html>