function loginSubmit()
{
	if(document.getElementById("login_input_id").value =="")
	{
		alert('아이디를 입력해주세요.');
		return false;
	}
	else if(document.getElementById("login_input_pw").value =="")
	{
		alert('비밀번호를 입력해주세요.');
		return false;
	}
	else
	{
		var loginForm = document.login_form;
		loginForm.action = "./login.do";
		loginForm.submit();
	}
}