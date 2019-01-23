window.addEventListener("load", function(){ 
	alert('test');
	var loginedUserNick = '${ logineduser.m_nick }';
	
	if (loginedUserNick=='')
	{
		alert('권한이 없어 게시판 목록으로 돌아갑니다.');
		location.href="./boardlist.do";
	}
})