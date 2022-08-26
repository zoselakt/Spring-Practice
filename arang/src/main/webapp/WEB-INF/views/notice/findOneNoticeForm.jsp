<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_one.css">
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script type="text/javascript">
	function gomain() { location.href="notice"}
	function goupdate() { location.href="updateNoticeForm?num=${noticeCommand.num}"}
	function godelete() { location.href="deleteNoticeForm?num=${noticeCommand.num}"}
</script>
</head>

<body>
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
  <div id="wrap">
	
	<form:form method="post">
            <table class="table_a">
                <c:forEach var="findOne" items="${noticeFindOne}">
                <tr class="textr">
                    <td class="textd">번호</td>
                    <td class="inner-textd">${findOne.num}</td>
                    <td class="textd">작성일</td>
                    <td class="inner-textd">${findOne.regDate}</td>
                    <td class="textd">작성자</td>
                    <td class="inner-textd">${findOne.writer}</td>
                    <td class="textd">조회수</td>
                    <td class="inner-textd">${findOne.readCnt}</td>
                </tr>
                <tr class="textr">
                	<td class="title">제목</td>
                </tr>
                <tr>
                	<td class="inner-title">${findOne.title}</td>                
                </tr>
                <tr class="textr">
                	<td class="content">내용</td>
                </tr>
                <tr>
                	<td class="inner-content">${findOne.content}</td>
                </tr>
                </c:forEach>
            </table>
            <div class="button-group">
                <input type="button" onclick="gomain()" value="목록으로">
                <input type="button" onclick="goupdate()" value="수정">
                <input type="button" onclick="godelete()" value="삭제">
            </div>
    </form:form>
    </div>
</body>
</html>
