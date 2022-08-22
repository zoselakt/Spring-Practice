<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <title>아티스트상세페이지</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/artist/artist_focus.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/swiper/swiper.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
  <script type="text/javascript" src="/fake_resources/js/slidebanner.js"></script>
</head>

<body>
  <div id="wrap">
    <jsp:include page="/WEB-INF/views/header/header.jsp"/>
    <!-- 아티스트상세페이지 -->
    <div id="artist">
      <div id="artist_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
            <div class="side_block">
              <div class="artist_info">
                <button><span class="futuraM">${artistInfo.genre}</span></button>
                <h3>${artistInfo.name_kor}</h3>
                <p class="e_name">${artistInfo.name_eng}</p>
                <p class="born">1984</p>
                <div class="artist_avatar">
                  <img src="${artistInfo.imgPath}" alt="윤라희jpg">
                </div>
              </div>
            </div>
            <div class="content_block">
              <div class="review">
                <h2>${artistInfo.title}</h2>
                <p>${artistInfo.description}</p>
                <p><br></p>
                <p>
                  <img src="${artistInfo.infoImgPath}" alt="artist_main">
                </p>
              </div>
              <div class="product">
                <h4>ArtWork</h4>
                  <div class="slick_list swiper mySwiper">
                    <div class="slick_trak swiper-wrapper">
                    <c:forEach var="artwork" items="${artworkList}">
                      <div class="item swiper-slide">
                          <div class="artwork_wrap" style="margin: text-align: center;">
                            <a href="/arang/artwork_board/artwork_info?id=${artwork.artistId}&wid=${artwork.wid}">
                            <img class="artwork" src="${artwork.artworkImgPath}"></a>
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
            <div class="side_block">
              <div class="a_list">
                <h3>추천작가</h3>
                <ul>
                  <li>
                    <a href="#">신수희</a>
                  </li>
                  <li>
                    <a href="#">최선호</a>
                  </li>
                </ul>
              </div>
              <div class="a_banner">
                <h3>이달의 전시</h3>
                <a href="#"><img class="exhibition_banner" src="/upload_img/banner/김선배너.jpg" alt="exhibition_banner"></a>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
 

    <!-- Swiper JS -->
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
    	autoplay: {
    		  delay: 2000,
    		  disableOnInteraction: false,
    		},
        slidesPerView: 3,
        spaceBetween: 10,
        slidesOffsetBefore: 23,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
    </script>
  
  
</body>

</html>
