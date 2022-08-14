<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Board</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
		<style>
			body {transform: scale(0.8); margin-top: -50px;}
		</style>
	</head>
	<body class="is-preload">
		<!-- Main -->
		<div id="main">
			<div class="wrapper">
				<div class="inner">

					<!-- Elements -->
					<header class="major">
						<h1>Board</h1>
						<p>게시글 등록</p>
					</header>
					<!-- Table -->
					<h3><a href="/board/list" class="button small">목록 보기</a></h3>
					<div class="content">
						<div class="form">
							<form method="post" action="/board/register" id="registForm">
								<div class="fields">
									<div class="field">
										<h4>제목</h4>
										<input name="title" placeholder="Title" type="text" />
									</div>
									<div class="field">
										<h4>내용</h4>
										<textarea name="content" rows="6" placeholder="Content" style="resize:none"></textarea>
									</div>
									<div class="field">
										<h4>작성자</h4>
										<input name="writer" placeholder="Writer" type="text" />
									</div>
								</div>
								<ul class="actions special">
									<li><input type="submit" class="button" value="등록" /></li>
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</body>
	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
</html>