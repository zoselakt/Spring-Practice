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
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_focus.css">
</head>

<body>
  <!-- header -->
  <div id="wrap">
  <br><br><br><br><br><br><br><br>
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
    <div class="board_wrapper">
      <h3 class="sub_title">My Storage</h3>
      <div>
		<form action="<c:url value='/notice/notice'/>" method="GET" name="search-form">
          <fieldset>
            <div class="field_inner">
              <label>검색어</label>
              	<!-- 검색 영역 -->
					<select name="field" id="field">
						<option value="title">제목</option>
						<option value="writer">글쓴이</option>
					</select>
					<input type="text" name="word" style="margin: 10px;"> 
					<input type="submit" value="검색">
              <a href="insertNoticeForm"><button class="board_btn service"  type="button">공지작성</button></a>
            </div>
          </fieldset>
        </form>
      </div>
      
      <form:form method="post">
      <table id="selectAll" class="storage_list artist">
      <thead class="theader">
        <tr class="selectr">
          <td class="selectd">No.</td>
          <td class="selectd">제목</td>
          <td class="selectd">작성자</td>
          <td class="selectd">조회수</td>
          <td class="selectd">작성일</td>
        </tr>
      </thead>
        <tbody class="tbodies">
        <c:forEach var="notice" items="${noticeList.content}">
	        <tr class="bodytr">
	          <td class="bodytd">${notice.num}</td>
	          <td class="bodytd"><a href="./findOneNoticeForm?num=${notice.num}">${notice.title}</a></td>
	          <td class="bodytd">${notice.writer}</td>
	          <td class="bodytd">${notice.readCnt}</td>
	          <td class="bodytd">${notice.regDate}</td>
	          <td class="bodytd"><a href="./updateNoticeForm?num=${notice.num}">수정</a></td>
			  <td class="bodytd"><a href="./deleteNoticeForm?num=${notice.num}">삭제</a></td>
	        </tr>
        </c:forEach>
	    </tbody>
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