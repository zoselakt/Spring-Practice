<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gomain() { location.href="notice"};
</script>
	<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_focus.css">
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
</head>

<body>
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
  <div id="wrap">
   <div class="headline_artworks">
      <h3>NOTICE UPDATE</h3>
    </div>
<form:form method="post" modelAttribute="noticeCommand">
    <div id="notice">
    <c:forEach var="update" items="${noticeUpdate}">
      <div id="notice_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
            <div class="side_block">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>제목</h2>
				  <form:input path="title" class="title" type="text" size="70" maxlength="100" value="${update.title}"/>
                  <!-- <input type="hidden" value="${noticeCommand.writer}"> -->
                </div>
              </div>
            </div>
            <div class="side_block">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>내용</h2>
				  <textarea id="content" name="content" cols="72" rows="20">${update.content}</textarea>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </c:forEach>
    <div class="btn_group2">
      <button type="submit" id="location_replace">수정</button> 
	  <input type="reset" value="초기화">
      <input type="button" onclick="gomain()" value="목록으로">
    </div>
    </div>
    </form:form>
    </div>
</body>
</html>