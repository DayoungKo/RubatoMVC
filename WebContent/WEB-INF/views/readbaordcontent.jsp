<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	pageContext.setAttribute("enter", "\n");
	pageContext.setAttribute("br", "<br/>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board_left_re.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board_view_main_re.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/replyprocess.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="layout/header.jsp" />
		<jsp:include page="layout/asideboardlist.jsp" />

		<section id="main">
			<img src="img/comm.gif">
			<h2 id="board_title">자유 게시판</h2>
			<div id="view_title_box">
				<span>${boardContentData.boardContentDto.bc_title}</span> <span id="info">${boardContentData.memberDto.m_nick} |
					조회 : ${boardContentData.boardContentDto.bc_look_count} | ${boardContentData.boardContentDto.bc_writedate}</span>
			</div>
			<div id="veiw_main_con" style="min-height: 10em;">
				<p id="view_content">
					${fn:replace(boardContentData.boardContentDto.bc_content, enter, br)}
				</p>
			</div>
			<c:if test="${boardContentData.boardContentDto.bc_attach_name != null}">
				<div id="veiw_attachments" style="padding: 20px 10px 10px 10px;">
					<a href="#">${boardContentData.boardContentDto.bc_attach_name}</a>
				</div>
			</c:if>
			<div id="comment_box" >
				<img id="title_comment" src="img/title_comment.gif">
				<div id="comment_view_box">
					<c:forEach var="replyData" items="${ubReplyDataList}">
						<table class="reply_table">
							<tr>
								<td class="reply_writer">
									<strong>${replyData.memberDto.m_nick}</strong>
								</td>
								<td class="reply_info">
									<c:if test="${logineduser.m_idx == replyData.memberDto.m_idx}">
										<a href="./deletebcreply.do?bc_reply_idx=${replyData.bcReplyDto.bc_reply_idx}&&bc_idx=${replyData.bcReplyDto.bc_idx}" class="reply_delete">댓글삭제</a>
									</c:if>
									${replyData.bcReplyDto.bc_reply_writedate}
								</td>
							</tr>
							<tr>
								<td colspan="2" class="reply_content">
									${fn:replace(replyData.bcReplyDto.bc_reply_content, enter, br)}
								</td>
							</tr>
						</table>
					</c:forEach>
				</div>
				<div class="clear"></div>
				<div id="comment_input_box">
					<c:choose>
						<c:when test="${!empty logineduser}">
							<form name="comment_input_form" method='post'>
								<input type="hidden" name="reply_writer_idx" value="${logineduser.m_idx}">
								<input type="hidden" name="reply_bc_idx" value="${boardContentData.boardContentDto.bc_idx}">
								<textarea id="reply_input_content" name="reply_input_content"></textarea>
								<img id="ok_ripple" src="img/ok_ripple.gif" onclick="replyCheckSubmit()">
							</form>
						</c:when>
						<c:otherwise>
							<h4>
								댓글은 <strong>로그인</strong> 후 작성할 수 있습니다.
							</h4>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div id="buttons">
				<c:if test="${logineduser.m_idx == boardContentData.boardContentDto.m_idx}">
					<a href="./updateboardcontentform.do?bc_idx=${boardContentData.boardContentDto.bc_idx}"><img src="img/modify.png"></a>
					<a href="./deleteboardcontent.do?bc_idx=${boardContentData.boardContentDto.bc_idx}"><img src="img/delete.png"></a>
				</c:if>
				<a href="./boardlist.do?search_cookie_remove='removeCookie'"><img src="img/list.png"></a> 
				<c:if test="${!empty logineduser}">
					<a href="./boardwriteform.do"><img src="img/write.png"></a>
				</c:if>
			</div>
		</section>
		<!-- section main -->
		<div class="clear"></div>

		<jsp:include page="layout/footer.jsp" />
	</div>
</body>
</html>