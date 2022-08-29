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
<form action="mypage_gallerist_modify" method="post" enctype="multipart/form-data">
<div id="wrap">

<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
<div class="container">
      <h4 class="sub_title">My Information</h4>
      <div class="info_simul">
        <div class="info_wrapper second">
          <div class="info_left gallerist">
            <div class="my_info">
                <table class="table_a">
                  <tr>
                    <td>
                      <div class="artist_avatar">
                        <img src="${gallerist.imgPath}">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input class="profile_up" type="file" name="imgFile" placeholder="이미지등록">
                      <input type="hidden" value="${artist.imgPath}" name="oriImg"/>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <h3>${gallerist.name}</h3>
                      <input type="hidden" value="${gallerist.name}" name="name"/>
                      <p class="e_name">gallerist</p>
                      
                    </td>
                  </tr>
                </table>
            </div>
          </div>
          <div class="info_center">
            <div class="my_info center gallerist">
                <table class="table_a">
                  <tr>
                    <td class="a_category">
                    <strong>이메일(아이디)</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${gallerist.email}
                      <input type="hidden" value="${gallerist.email}" name="email"/>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>비밀번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      <input type="text" class="small" placeholder="새 비밀번호" name="passwd"/>
                    </td>
                  </tr>
                </table>
            </div>
          </div>
          <div class="info_right">
            <div class="my_info right">
                <table class="table_a">
                <tr>
                  <td class="a_category">
                    <strong>주민등록번호</strong>
                  </td>
                </tr>
                <tr>
                  <td class="a_data">
                    ${ssn}
                    <input type="hidden" value="${ssn}" name="ssn"/>
                  </td>
                </tr>
                <tr>
                  <td class="a_category">
                    <strong>전화번호</strong>
                  </td>
                </tr>
                <tr>
                  <td class="a_data">
                    <input type="text" class="small" value="${gallerist.phone}" name="phone"/>
                  </td>
                </tr>
                </table>
            </div>
          </div>
        </div>
      </div>
      <div class="btn2_group">
        <a href="/arang/mypage/mypage_gallerist"><button type="submit" class="btn2">저장</button></a>
        <a href="/arang/mypage/mypage_gallerist"><button type="button" class="btn2">취소</button></a>
      </div>
    </div>

</div>
</form>
</body>
</html>