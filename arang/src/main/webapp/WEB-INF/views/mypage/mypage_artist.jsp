<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fake_resources/css/default/normalize.css">
<link rel="stylesheet" href="/fake_resources/css/default/default.css">
<link rel="stylesheet" href="/fake_resources/css/default/header.css">
<link rel="stylesheet" href="/fake_resources/css/login/input_style.css">
<link rel="stylesheet" href="/fake_resources/css/join/join_artist.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/mypage_default.css">
</head>
<body>
<div id="wrap">

<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>

<div class="container">
      <h4 class="sub_title">My Information</h4>
      <div class="info_simul">
        <div class="info_wrapper first">
          <div class="info_left">
            <div class="my_info">
              <form>
                <table class="table_a">
                  <tr>
                    <td>
                      <div class="artist_avatar">
                        <img src="${artist.imgPath}" alt="윤라희jpg">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <h3>${artist.name_kor}</h3>
                      <p class="e_name">${artist.name_eng}</p>
                    </td>
                  </tr>
                </table>
              </form>
            </div>
          </div>
          <div class="info_center">
            <div class="my_info">
              <form>
                <table class="table_a">
                  <tr>
                    <td class="a_category">
                    <strong>이메일(아이디)</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${artist.email}
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>비밀번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ********
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>주민등록번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${ssn}
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>전화번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${artist.phone}
                    </td>
                  </tr>
                </table>
              </form>
            </div>
          </div>
          <div class="info_right">
            <div class="my_info">
              <form>
                <table class="table_a">
                  <tr>
                    <td class="a_category">
                      <strong>경력</strong>
                    </td>
                  </tr>
                   <c:forTokens var="career" items="${artist.career}" delims=";">
                   <tr>
                    <td>
                      ${career}
                    </td>
                   </tr>
                  </c:forTokens>
                  <tr>
                  </tr>
                </table>
              </form>
            </div>
          </div>
        </div>
      </div>
      <div class="btn2_group">
        <a href="/arang/mypage/mypage_artist_modify"><button class="btn2">내 정보 수정</button></a>
      	<a href="/arang/mypage/add_artist_info"><button class="btn2">내 아티스트정보 입력하기</button></a>
        <a href="/arang/pages/add_artwork"><button class="btn2">작품 등록</button></a>
      </div>
    </div>
</div>
</body>
</html>