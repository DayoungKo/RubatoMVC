<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loginprocess.js"></script>
<!-- <style>
	#success_login p {
		margin: 1em 0;
		text-align: center;
		font-size: 1.2em;
	}
	#logout_btn{
		float: right;
		margin-top: 1em;
		margin-right: 1em;
		font-size: 1em;
	}
</style> -->
<article id="login_box">
	<img id="login_title" src="img/ttl_login.png">
	<c:choose>
		<c:when test="${empty logineduser}">
			<div id="input_button">
				<form name="login_form" method="post">
					<input type="hidden" name="page_pre_path"
						value="${pageContext.request.contextPath}">
					<ul id="login_input">
						<li><input type="text" id="login_input_id" name="id"></li>
						<li><input type="password" id="login_input_pw" name="pw"></li>
					</ul>
					<a href="javascript:loginSubmit();"><img id="login_btn" src="img/btn_login.gif"></a>
				</form>
			</div>
			<div class="clear"></div>
			<div id="join_search">
				<a href="#"><img src="img/btn_join.gif"
					onclick="location.href='./joinmemberform.do'"></a> <img
					src="img/btn_search.gif">
			</div>
		</c:when>
		<c:otherwise>
			<div id="success_login">
				<p>${ logineduser.m_nick }님환영합니다.</p>
				<input type="button" id="logout_btn" value="로그아웃"
					onclick="location.href='./logout.do'">
			</div>
		</c:otherwise>
	</c:choose>
</article>
