<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board_left_re.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board_list_main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board_list_mine.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/boardlistprocess.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="layout/header.jsp" />
		<jsp:include page="layout/asideboardlist.jsp" />
		
		<section id="main">
			<img src="img/comm.gif">
			<h2 id="board_title">자유 게시판</h2>
			<div id="total_search">
				<div id="total">▷ 총 ${allBoardListDataSize}개의 게시물이 있습니다.</div>
				<div id="paging">
					<select id="select_paging" name="select_view_boardList_size" onchange="changePaingNum()">
						<option value="">--개씩</option>
						<option value="15">15개씩</option>
						<option value="20">20개씩</option>
						<option value="30">30개씩</option>
					</select>
				</div>
				<div id="search">
					<div id="select_img">
						<img src="img/select_search.gif">
					</div>
					<form name="select_form" method="post">
						<div id="search_select">
							<select name="search_option">
								<option value="about_title">제목</option>
								<option value="about_content">내용</option>
								<option value="about_writer">글쓴이</option>
							</select>
						</div>
						<div id="search_input">
							<input id="search_content" type="text" name="search_content">
						</div>
						<div id="search_btn">
							<a href="#"><img src="img/search_button.gif" onclick="selectCheck()"></a>
						</div>
					</form>
				</div>
			</div>
			<table>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>일시</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="data" items="${boardListData}">
					<tr>
						<td class="col1">${data.boardContentDto.bc_idx}</td>
						<td class="col2"><a href="./readbaord.do?bc_idx=${data.boardContentDto.bc_idx}">${data.boardContentDto.bc_title}</a></td>
						<td class="col3">${data.memberDto.m_nick}</td>
						<td class="col4">${data.boardContentDto.bc_writedate}</td>
						<td class="col5">${data.boardContentDto.bc_look_count}</td>
					</tr>
				</c:forEach>
			</table>
			<div id="buttons">
				<div class="col1">
					<c:if test="${pagingData.nowPageNum != 1}">
						<a href="./boardlist.do?page_num=${pagingData.nowPageNum-1}&&select_view_boardList_size=${pagingData.viewBoardListSize}">◀ 이전</a>
					</c:if>
				 	<c:forEach var="pageNum" begin="1" end="${pagingData.totalPageSize}" step="1">
				 		<a href="./boardlist.do?page_num=${pageNum}&&select_view_boardList_size=${pagingData.viewBoardListSize}">${pageNum}</a>
				 	</c:forEach>
				 	<c:if test="${pagingData.nowPageNum != pagingData.totalPageSize}">
				 		<a href="./boardlist.do?page_num=${pagingData.nowPageNum+1}&&select_view_boardList_size=${pagingData.viewBoardListSize}">다음 ▶</a>
				 	</c:if>
				</div>
				<div class="col2">
					<a href="./boardlist.do?search_cookie_check=removeCookie"><img src="img/list.png"></a>
					<c:if test="${!empty logineduser}">
						<a href="./boardwriteform.do"><img src="img/write.png"></a>
					</c:if>
				</div>
			</div>
		</section>
		<!-- section main -->
		<div class="clear"></div>
		
		<jsp:include page="layout/footer.jsp" />
	</div>
</body>
</html>