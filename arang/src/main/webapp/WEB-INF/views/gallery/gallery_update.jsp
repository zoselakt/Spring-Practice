<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <title>갤러리 업데이트</title>
	<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/artist/artist_focus.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/gallery/gallery_focus.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/mypage/artwork_upload.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/mypage/gallery_upload.css">
  <script src="https://cdn.ckeditor.com/ckeditor5/35.0.1/classic/ckeditor.js"></script>
</head>
<script type="text/javascript">
	function gomain() { location.href="gallery"};
</script>
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

<body>
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
  <div id="wrap">
    <div class="headline_artworks">
      <h3>GALLERY UPDATE</h3>
    </div>

    <!-- 갤러리상세페이지 -->
  <form:form method="post" modelAttribute="galleryCommand" enctype="multipart/form-data">
    <div id="artist">
    <c:forEach var="update" items="${galleryUpdate}">
      <div id="artist_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
            <div class="side_block">
              <div class="artist_info">
                <div class="input_box_left">
                  <input type="text" placeholder="갤러리이름(한글)" name="galleryName_kor" value="${update.galleryName_kor}">
                  <input type="text" placeholder="갤러리이름(영문)" name="galleryName_eng" value="${update.galleryName_eng}">
                  <input type="text" placeholder="년도 ex)2002" name="since" value="${update.since}">
                  <input type="hidden" name="galleristEmail">
                  <div class="artist_avatar">
                    <input type="file" id="input-file" name="imgName2" multiple>
                    <!-- <img src="../resources/img/gallerys/2.jpg" alt="2"> -->
                  </div>
                </div>
              </div>
            </div>
            <div class="content_block">
              <div class="review">
                <h2>ARARIO GALLERY</h2>
                <p><textarea id="content" class="textarea_box" name="description" cols="43" rows="7">${GalleryInfoCommand.description}</textarea></p>
                <p><br></p>
                <p>
                <div id="box2">
              	<input type="button" value="추가" onclick="add_textbox()">
              	<c:forTokens var="infoImg" items="${GalleryInfoCommand.infoImgPath}" delims=";">
            		<img src="${infoImg}">
            	</c:forTokens>
        		</div>
                </p>
              </div>
              <div class="product">
                <h4 class="sub_title">Gallery Information</h4>
                <div class="artwork_simul">
                  <div class="artwork_wrapper">
                    <div class="artwork_info_wrap">
                      <div class="artwork_info">
                        <div class="info">
                          <div class="info_block">
                            <div class="first">주소(Address)</div>
                            <div class="last">
                              <input type="text" placeholder="주소" name="address" value="${update.address}">
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">크기(Size)</div>
                            <div class="last">
                              <input type="text" placeholder="ex) 전시면적 900㎡ / 9층" name="area" value="${update.area}">
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">시간(Hours)</div>
                            <div class="last">
                              <input type="text" placeholder="ex) 오전 11시 ~ 오후 6시 (월요일 휴관)" name="openClose" value="${update.openClose}">
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">이메일(Email)</div>
                            <input type="text" placeholder="이메일" name="galleryEmail" value="${update.galleryEmail}">
                          </div>
                          <div class="info_block">
                            <div class="first">전화번호(Phone)</div>
                            <input type="text" placeholder="전화번호" name="galleryPhone" value="${update.galleryPhone}">
                            <br>
                            <input type="text" placeholder="갤러리스트네임" name="representer" value="${update.representer}">
                            <br>
                            <input type="text" placeholder="갤러리스트넘버" name="representerNum" value="${update.representerNum}">
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
	    <div class="btn_group2">
	      <button type="submit">수정</button> 
		  <input type="reset" value="초기화">
	      <input type="button" onclick="gomain()" value="목록으로">
	    </div>
    </div>
    </form:form>
  </div>
  
  <script type="text/javascript" src="/fake_resources/js/ckeditor.js"></script>
</body>
</html>
