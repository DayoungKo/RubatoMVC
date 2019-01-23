<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>회원가입</title>

<%--루바토 UI --%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main_re.css">
<%--회원가입 UI --%>
<link
	href="${pageContext.request.contextPath}/css/joinmember_bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/joinmember_font-awesome.min.css"
	media="screen" title="no title">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/joinmember_style.css"
	media="screen" title="no title">
<%-- 회원가입 javascript, jQuery --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/joinmember_bootstrap.min.js"></script>
<script>
function submitAfterCheck()
{
	var inputId = document.getElementById('inputID').value.trim();
	var inputPw = document.getElementById('inputPassword').value;
	var inputPwChk = document.getElementById('inputPasswordCheck').value;
	var inputNick = document.getElementById('inputNick').value.trim();
	var inputPhone = document.getElementById('inputNumber').value.trim();
	//정규식
	var checkCharId =  /[^A-Za-z0-9]{5,10}$/;
	var checkCharPw;
	var checkCharNick = /[^\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,10}$/;
	var checkLengthPhone1 = /^01([0|1|6|7|8|9]?)/;
	var checkLengthPhone2 = /[0-9]{3,4}$/;
	var checkLengthPhone3 = /[0-9]{4}$/;
	
	if(inputId == "")
	{
		alert("아이디를 입력해주세요.");
		return false;
	}
	if(checkCharId.test(inputId))
	{
		alert("유효한 아이디를 입력해주세요.")
		return false;
	}
	//아이디 중복체크..
	if(inputPw=="" | inputPwChk=="")
	{
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	if(inputPw != inputPwChk)
	{
		alert("비밀번호를 다시 확인해주세요.");
		return false;
	}
	if(checkCharPw.test(inputPw))
	{
		alert("유효한 비밀번호를 입력해주세요.")
		return false;
	}
	if(inputNick == "")
	{
		alert("별명을 입력해주세요.")
		return false;
	}
	if(checkCharNick.test(inputNick))
	{
		alert("유효한 별명을 입력해주세요.")
		return false;
	}
	if(inputPhone=="")
	{
		alert("핸드폰 번호를 입력해주세요.")
		return false;
	}
	if(!checkLengthPhone1.test(inputPhone.substring(0,3)))
	{
		alert("유효한 핸드폰 번호를 입력해주세요.")
		return false;
	}
	if(!checkLengthPhone2.test(inputPhone.substring(3,7)))
	{
		alert("유효한 핸드폰 번호를 입력해주세요.")
		return false;
	}
	if(!checkLengthPhone3.test(inputPhone.substring(7,10)))
	{
		alert("유효한 핸드폰 번호를 입력해주세요.")
		return false;
	}
	
	/* var joinForm = document.resist_form
	joinForm.action="#"
	//joinForm.action="./joinmember.do"
	joinForm.submit(); */
}
function joinedIdCheck()
{
}
function joinCancleChk() {
	if (confirm("취소하시겠습니까?")) {
		window.history.back();
	}
	return false;
}
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="layout/header.jsp" />

		<section id="main">
			<article class="container">
				<div class="col-md-12">
					<div class="page-header">
						<h1>
							회원가입 <small>Join</small>
						</h1>
					</div>
					<form class="form-horizontal" name="resist_form" id="resist_form" method="post">
						<div class="form-group">
							<label class="col-sm-3 control-label" for="inputID">아이디</label>
							<div class="col-sm-6">
								<input class="form-control" id="inputID" type="text"
									placeholder="아이디" name="join_input_id">
								<p class="help-block">영문, 숫자 포함 5자 이상 10자 이내</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
							<div class="col-sm-6">
								<input class="form-control" id="inputPassword" type="password"
									placeholder="비밀번호" name="join_input_pw">
								<p class="help-block">영문, 숫자 포함 8자 이상 20자 이내</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="inputPasswordCheck">비밀번호
								확인</label>
							<div class="col-sm-6">
								<input class="form-control" id="inputPasswordCheck"
									type="password" placeholder="비밀번호 확인">
								<p class="help-block">비밀번호를 한번 더 입력해주세요.</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="inputNick">별명</label>
							<div class="col-sm-6">
								<input class="form-control" id="inputNick" type="text"
									name="join_input_nick" placeholder="별명">
								<p class="help-block">한글/영문 10자 이내</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="inputNumber">휴대폰번호</label>
							<div class="col-sm-6">
								<input type="tel" class="form-control" id="inputNumber"
									name="join_input_phone" placeholder="- 없이 입력해 주세요" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12 text-center">
								<button class="btn btn-primary" onclick="submitAfterCheck()">
									회원가입
								</button>
								<button class="btn btn-danger" onclick="return joinCancleChk()">
									가입취소
								</button>
							</div>
						</div>
					</form>
					<hr>
				</div>
			</article>
		</section>
		<!-- section main -->
		<div class="clear"></div>

		<jsp:include page="layout/footer.jsp" />
	</div>
</body>
</html>