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
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_All.css">
<script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/35.0.1/classic/ckeditor.js"></script>
<script type="text/javascript">function gomain() { location.href="notice"}</script>
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
     <h3>NOTICE RESIST</h3>
   </div>
<form:form method="post" modelAttribute="noticeCommand" enctype="multipart/form-data">
    <div id="notice">
      <div id="notice_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
            <div class="side_block">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>제목</h2>
				  <form:input path="title" class="title" type="text" size="70" maxlength="100"/>
                  <input type="hidden" value="${noticeCommand.writer}">
                </div>
              </div>
            </div>
            <div class="side_block">
              <div class="notice_info">
                <div class="input_box_left">
                  <h2>내용</h2>
				  <form:textarea path="content" class="content" cols="72" rows="200"></form:textarea>
                </div>
              </div>
            </div>
             <div class="side_block">
              <div class="notice_info">
	       		<h2>이미지</h2>
	            <div id="box2">
		       		<div class="upload_box">
		      			 <input id="input-file" name="imgName2" type="file" placeholder="이미지등록" multiple/>
		    		</div><br>
	         		<input type="button" value="추가" onclick="add_textbox()">
	     		</div>
              </div>
          </div>
        </div>
      </div>
	    <div class="btn_group2">
	      <button type="submit">등록</button> 
		  <input type="reset" value="초기화">
	      <input type="button" onclick="gomain()" value="목록으로">
	    </div>
   	 </div>
    </div>
    </form:form>
    </div>
    <script type="text/javascript" src="/fake_resources/js/ckeditor.js"></script>
    
</body>
</html>