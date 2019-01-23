// 회원가입 취소
function joinCancleChk() {
	if (confirm("취소하시겠습니까?")) {
		window.history.back();
	}
	return false;
}