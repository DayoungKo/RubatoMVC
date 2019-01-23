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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board_left_re.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board_write_main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/boardcontentprocess.js"></script>
<!-- <script>
window.addEventListener("load", function(){ 
	
	var loginedUserNick = '${ logineduser.m_nick }';
	
	if (loginedUserNick=='')
	{
		alert('권한이 없어 게시판 목록으로 돌아갑니다.');
		location.href="./boardlist.do";
	}
})
</script> -->
</head>
<body>
	<div id="wrap">
		<jsp:include page="layout/header.jsp" />
		<jsp:include page="layout/asideboardlist.jsp" />
	
		<section id="main">
			<img src="img/comm.gif">
			<h2 id="board_title">자유 게시판</h2>
			<div id="write_title">
				<h2>글쓰기</h2>
			</div>
			<form name="bc_input_form" method="post">
				<input type="hidden" name="writer_idx" value="${ logineduser.m_idx }">
				<table>
					<tr id="name">
						<td class="col1">이름</td>
						<td class="col2">${ logineduser.m_nick }</td>
					</tr>
					<tr id="subject">
						<td class="col1">제목</td>
						<td class="col2"><input type="text" id="input_title" name="input_title"></td>
					</tr>
					<tr id="content">
						<td class="col1">내용</td>
						<td class="col2"><textarea id="input_content" name="input_content"></textarea></td>
					</tr>
					<tr id="upload">
						<td class="col1">업로드 파일</td>
						<td class="col2"><input	type="file" name="upload_attach"></td>
					</tr>
				</table>
				<div id="buttons">
					<a href="#"><img src="img/ok.png" onclick="boardContentWriteSubmit()"></a> <a
						href="./boardlist.do"><img src="img/list.png"></a>
				</div>
			</form>
		</section>
		<!-- section main -->
		<div class="clear"></div>
		<jsp:include page="layout/footer.jsp" />
	</div>
</body>
</html>