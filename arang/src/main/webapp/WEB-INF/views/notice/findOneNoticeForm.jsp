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
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_focus.css">
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script type="text/javascript">
	function gomain() { location.href="notice"}
	function goupdate() { location.href="updateNoticeForm?num=${findOne.num}"}
	function godelete() { location.href="deleteNoticeForm?num=${findOne.num}"}
	
      function location_replace(){          
		  var link_url = "notice";      
		  location.replace(link_url);
		  document.getElementById("location_replace").innerHTML = link_url;	 
	  }
</script>
<style type="text/css">
	table{
		align-items: center;
		justify-content: center;
	}
	
</style>
</head>
<body>
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
  <div id="wrap">
<form:form method="post">
    <div id="notice">
      <div id="notice_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
          <c:forEach var="findOne" items="${noticeFindOne}">
            <div class="side_top">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>번호</h2>
				  <div>${findOne.num}</div>
                </div>
              </div>
            </div>
            <div class="side_top">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>작성일</h2>
				  <div>${findOne.regDate}</div>
                </div>
              </div>
            </div>
            <div class="side_top">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>작성자</h2>
				  <div>${findOne.writer}</div>
                </div>
              </div>
            </div>
            <div class="side_block">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>제목</h2>
				  <div>${findOne.title}</div>
                </div>
              </div>
            </div>
            <div class="side_block">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>내용</h2>
				  <div>${findOne.content}</div>
                </div>
              </div>
            </div>
            </c:forEach>
      		<input type="button" onclick="gomain()" value="목록으로">
      		<input type="button" onclick="goupdate()" value="수정">
      		<input type="button" onclick="godelete()" value="삭제">
          </div>
        </div>
      </div>
    </div>
    </form:form>
    </div>
</body>
</html>