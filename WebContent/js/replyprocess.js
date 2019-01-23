function replyCheckSubmit()
{
	if(document.getElementById("reply_input_content").value =="")
	{
		alert('댓글 내용을 입력해주세요.');
		return false;
	}
	else
	{
		var replyInputForm = document.comment_input_form;
		replyInputForm.action = "./writereplyonbc.do";
		replyInputForm.submit();
	}
}