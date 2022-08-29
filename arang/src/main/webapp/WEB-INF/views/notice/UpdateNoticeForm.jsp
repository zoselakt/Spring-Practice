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
	function goNoticeOneForm() { location.href="findOneNoticeForm?num=${noticeCommand.num}"}
</script>
	<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_CreateUpdate.css">
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
  <script src="https://cdn.ckeditor.com/ckeditor5/35.0.1/classic/ckeditor.js"></script>
  <script>
cnt = 0;
const add_textbox = () => {
	if ( cnt < 2 ) {
		const box = document.getElementById("box2");
		const newP = document.createElement('tr');
		newP.innerHTML = "<div class='upload_box'> <input type='file' id='input-file' name='imgName2' multiple>"
		+ "</div> <br> <input type='button' value='삭제' onclick='remove(this)'>";
		box.appendChild(newP);
		cnt++;
	}
}
const remove = (obj) => {
    document.getElementById('box2').removeChild(obj.parentNode);
    cnt--;
}
</script>
</head>

<body>
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
  <div id="wrap">
   <div class="headline_artworks">
      <h3>NOTICE UPDATE</h3>
    </div>
<form:form method="post" modelAttribute="noticeCommand" enctype="multipart/form-data">
    <div id="notice">
      <div id="notice_detail">
        <div class="container notice">
   		<c:forEach var="update" items="${noticeUpdate}">
          <div class="detail_wrapper notice d-flex">
            <div class="content_block">
              <div class="headline">
   				<h3>MODIFY</h3>
  			  </div>
 			  <div class="review">
              <p class="sub_txt title">제목</p>
              <form:input path="title" class="title" type="text" size="100" maxlength="100" value="${update.title}" />
             	 <input type="hidden" value="${update.writer}">
              <p class="sub_txt inner">내용</p>
              <textarea id="content" class="content" name="content" cols="100" rows="100">${update.content}</textarea>
           	  </div>
            </div>
          </div>
      	  </c:forEach>
          <div class="btn_group2">
		      <button type="submit" class="btn2">수정</button> 
			  <button type="button" onclick="goNoticeOneForm()" class="btn2">취소</button>
		  </div>
        </div>
      </div>
    </div>
    </form:form>
    </div>
    
    <script type="text/javascript" src="/fake_resources/js/ckeditor.js"></script>
</body>
</html>