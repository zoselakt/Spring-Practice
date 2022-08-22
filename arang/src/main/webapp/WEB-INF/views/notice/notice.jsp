<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <title>Notice</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/login/input_style.css"/>
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
</head>

<body>
  <!-- header -->
  <div id="wrap">
  
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
    <div class="board_wrapper">
      <h3 class="sub_title">My Storage</h3>
      <div>
        <form>
          <fieldset>
            <div class="field_inner">
              <label>검색어</label>
              <input type="text">
              <a href="#"><button class="board_btn" type="button">검색</button></a>
              <a href="insertNoticeForm"><button class="board_btn service"  type="button">공지작성</button></a>
            </div>
          </fieldset>
        </form>
      </div>
      
      <form:form method="post">
      <table class="storage_list artist">
        <tr>
          <td>No.</td>
          <td>제목</td>
          <td>작성자</td>
          <td>조회수</td>
          <td>작성일</td>
        </tr>
        <c:forEach var="notice" items="${noticeList.content}">
	        <tr>
	          <td>${notice.num}</td>
	          <td><a href="./findOneNoticeForm?num=${notice.num}">${notice.title}</a></td>
	          <td>${notice.writer}</td>
	          <td>${notice.readCnt}</td>
	          <td>${notice.regDate}</td>
	          <td><a href="./updateNoticeForm?num=${notice.num}">글 수정</a></td>
			  <td><a href="./deleteNoticeForm?num=${notice.num}">글 삭제</a></td>
	        </tr>
        </c:forEach>
      </table>
      </form:form>
      
      <!-- 페이징 버튼 영역 -->
	<div class="paging-area">
		<ul class="pagination">
			<!-- 시작 -->
			<c:choose>
				<c:when test="${noticeList.first}"></c:when>
				<c:otherwise>
					<li class="page_item"><a class="page_link" href="<c:url value='/notice/notice?page=0'/>">처음</a></li>
					<li class="page_item"><a class="page_link" href="<c:url value='/notice/notice?page=${noticeList.number-1}'/>">&larr;</a></li>
				</c:otherwise>
			</c:choose>
			<!-- 페이지 그룹 -->
			<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
				<c:choose>
					<c:when test="${noticeList.pageable.pageNumber+1 == i}">
						<li class="page_item disabled"><a class="page-link" href="<c:url value='/notice/notice?page=${i-1}'/>">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page_item"><a class="page_link" href="<c:url value='/notice/notice?page=${i-1}'/>">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 끝 --> 
			<c:choose>
				<c:when test="${noticeList.last}"></c:when>
				<c:otherwise>
					<li class="page_item"><a class="page_link" href="<c:url value='/notice/notice?page=${noticeList.number+1}'/>">&rarr;</a></li>
					<li class="page_item"><a class="page_link" href="<c:url value='/notice/notice?page=${noticeList.totalPages-1}'/>">마지막</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
    </div>
  </div>
  </body>
</html>
