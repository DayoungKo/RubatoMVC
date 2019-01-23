<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main_re.css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="layout/header.jsp" />
		<jsp:include page="layout/asideindex.jsp" />
		
		<section id="main">
			<img src="img/main_img.png">
			<section id="notice_free_youtube">
				<article id="notice">
					<!-- 공지사항 -->
					<div class="latest_title">
						<img class="latest_img" src="img/latest1.gif"> <img
							class="more" src="img/more.gif">
						<div class="clear"></div>
					</div>
					<div class="latest_content">
						<img class="image" src="img/book_pen.gif">
						<ul class="list">
							<li>
								<div class="subject">루바토 개편과 사이트 이용...</div>
								<div class="date">2017-09-20</div>
								<div class="clear"></div>
							</li>
							<li>
								<div class="subject">루바토 개편과 사이트 이용...</div>
								<div class="date">2017-09-20</div>
								<div class="clear"></div>
							</li>
							<li>
								<div class="subject">루바토 개편과 사이트 이용...</div>
								<div class="date">2017-09-20</div>
								<div class="clear"></div>
							</li>
							<li>
								<div class="subject">루바토 개편과 사이트 이용...</div>
								<div class="date">2017-09-20</div>
								<div class="clear"></div>
							</li>
						</ul>
					</div>
				</article>
				<article id="free">
					<!-- 자유 게시판 -->
					<div class="latest_title">
						<img class="latest_img" src="img/latest2.gif"> <img
							class="more" src="img/more.gif">
						<div class="clear"></div>
					</div>
					<div class="latest_content">
						<img class="image" src="img/book_pen.gif">
						<ul class="list">
							<li>
								<div class="subject">까스통님의 선물인 보드카...</div>
								<div class="date">2017-09-20</div>
								<div class="clear"></div>
							</li>
							<li>
								<div class="subject">까스통님의 선물인 보드카...</div>
								<div class="date">2017-09-20</div>
								<div class="clear"></div>
							</li>
							<li>
								<div class="subject">까스통님의 선물인 보드카...</div>
								<div class="date">2017-09-20</div>
								<div class="clear"></div>
							</li>
							<li>
								<div class="subject">까스통님의 선물인 보드카...</div>
								<div class="date">2017-09-20</div>
								<div class="clear"></div>
							</li>
						</ul>
					</div>
				</article>
				<article id="youtube">
					<!-- YOUTUBE 동영상 -->
					<div class="latest_title">
						<img class="latest_img" src="img/latest3.gif"> <img
							class="more" src="img/more.gif">
						<div class="clear"></div>
					</div>
					<img id="youtube_img" src="img/bach.jpg">
				</article>
			</section>
			<!-- notice_free_youtube -->
			<section id="gallery">
				<img src="img/latest4.gif">
				<div id="gallery_box">
					<div id="gallery_list">
						<div class="items">
							<ul>
								<li><img src="img/img1.jpg"></li>
								<li>기타 페스티벌 4중주</li>
							</ul>
						</div>
						<div class="items">
							<ul>
								<li><img src="img/img1.jpg"></li>
								<li>기타 페스티벌 4중주</li>
							</ul>
						</div>
						<div class="items">
							<ul>
								<li><img src="img/img1.jpg"></li>
								<li>기타 페스티벌 4중주</li>
							</ul>
						</div>
					</div>
					<!-- galley_list -->
				</div>
				<!-- gallery_box -->
			</section>
			<!-- gallery -->
		</section>
		<!-- section main -->
		<div class="clear"></div>
		
		<jsp:include page="layout/footer.jsp" />
	</div>
</body>
</html>