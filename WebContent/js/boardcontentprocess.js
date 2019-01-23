function boardContentWriteSubmit()
{
	if(document.getElementById("input_title").value =="")
	{
		alert('제목을 입력해주세요.');
		return false;
	}
	else if(document.getElementById("input_content").value =="")
	{
		alert('내용을 입력해주세요.');
		return false;
	}
	else
	{
		var boardForm = document.bc_input_form;
		boardForm.action = "./boardwrite.do";
		boardForm.submit();	
	}
}
function boardContentUpdateSubmit()
{
	if(document.getElementById("input_title").value =="")
	{
		alert('제목을 입력해주세요.');
		return false;
	}
	else if(document.getElementById("input_content").value =="")
	{
		alert('내용을 입력해주세요.');
		return false;
	}
	else
	{
		var boardForm = document.bc_input_form;
		boardForm.action = "./updateboardcontent.do";
		boardForm.submit();
	}
}