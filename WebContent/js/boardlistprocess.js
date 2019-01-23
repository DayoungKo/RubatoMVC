function selectCheck()
{
	if(document.getElementById('search_content').value =="")
	{
		alert('검색할 내용을 입력해주세요.');
		return false;
	}
	else
	{
		var selectForm = document.select_form;
		selectForm.action = "./boardlist.do?search_cookie_check=modifyCookie";
		selectForm.submit();
	}
}

function changePaingNum(){
	var selectPaging = document.getElementById("select_paging");
	var pagingNum = selectPaging.options[selectPaging.selectedIndex].value;
	
	window.location.href="./boardlist.do?select_view_boardList_size="+pagingNum;
}
