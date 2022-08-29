<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
  <title>like_page</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="stylesheet" href="/fake_resources/css/default/normalize.css">
<link rel="stylesheet" href="/fake_resources/css/default/default.css">
<link rel="stylesheet" href="/fake_resources/css/artist/artist.css">
<link rel="stylesheet" href="/fake_resources/css/main/main.css">
  <link rel="stylesheet" href="/fake_resources/css/main/main.css">
  <link rel="stylesheet" href="/fake_resources/css/like/like.css">
<script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script type="text/javascript" src="/fake_resources/js/common.js"></script>
</head>

<body>
  <div id="wrap">
	<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
    <div class="container">
      <h4 class="sub_title">Wish list</h4>
      <p class="list_name">ARTIST<small>${artistCount}</small></p>
              <div class="sub_page_context">
            <div class="grid_wrapper">              
              <div class="row artist_list">
              
                <c:forEach var="artworkPage" items="${artistList}" begin="0" end="2">
                <div class="col artist_item ${artworkPage.genre}">
                  <div class="artist_info d-flex flex-row">
                    <div class="artist_avatar">
                      <a href="/arang/artist_board/artist_depth?id=${artworkPage.aid}">
                      <img src="${artworkPage.imgPath}"></a>
                    </div>
                    <div class="artist_text">
                      <div class="first">
                        <span>${artworkPage.name_kor}</span>
                        <span class="genre_tag">${artworkPage.genre}</span>
                      </div>
                      <div class="second d-flex flex-row">
                        <div>날 것 그대로의 본질에 우연적 효과를 불어넣다.</div>
                      </div>
                    </div>
                  </div>
                  <div class="banner_wrap">
                    <a href="/arang/artwork_board/artwork_info?id=${artworkPage.aid}&wid=${artworkPage.wid}">
                      <div class="artwork_banner">
  							<img class="artwork" src="${artworkPage.artworkImgPath}">
                      </div>
                    </a>
                  </div>
                </div>
                </c:forEach>
              </div>
      <p class="list_name">ARTWORK</p>
      <div class="product">
        <div id="product2" class="item_list1">
          <div class="slick_list">
            <div class="slick_trak mypage" style="display: flex;">
            <c:forEach var="artwork" items="${artworkList}" begin="0" end="4">
              <div class="item">
                  <div class="artwork_wrap">
                    <a href="/arang/artwork_board/artwork_info?id=${artwork.artistId}&wid=${artwork.wid}">
                    <img class="artwork" src="${artwork.artworkImgPath}" onload="JavaScript:artwork_small_middle(this)"></a>
                  </div>
                <figcaption>
                  <h5>${artwork.name}</h5>
				<p>${artwork.technique}</p>
				</figcaption>
			</div>			
		</c:forEach>
				</div>
            </div>
          </div>
        </div>
      <p class="list_name gallery">GALLERY</p>
      <div class="row artist_list">
              <c:forEach var="gallery" items="${galleryList}" begin="0" end="2">
                <div class="col artist_item">
                  <div class="artist_info d-flex flex-row">
                    <div class="artist_avatar">
                      <a href="/arang/gallery/gallery_focus?code=${gallery.code}">
                      	<img src="${gallery.galleryImgPath}">
                      </a>
                    </div>
                    <div class="artist_text">
                      <div class="first">
                        <span>${gallery.galleryName_eng}</span>
                      </div>
                      <div class="second d-flex flex-row">
                        <div>${gallery.address}</div>
                      </div>
                    </div>
                  </div>
                  <div class="banner_wrap">
                    <a href="#">
                      <div class="artwork_banner">
                        <a href="/arang/gallery/gallery_focus?code=${gallery.code}">
                        	<img src="${gallery.infoImgPath}" alt="2">
                        </a>
                      </div>
                    </a>
                  </div>
                </div>
              </c:forEach>
                </div>   
    </div>
  </div>
</body>

</html>