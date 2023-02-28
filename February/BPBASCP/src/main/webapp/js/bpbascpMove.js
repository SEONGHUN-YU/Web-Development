function goJoin() {
	location.href = "JoinController";
}

function logout() {
	location.href = "LoginController" // LogoutController를 새로 만들어도 됨
}

function goMemberInfo() {
	location.href = "MemberInfoController";
}

function bye() {
	// alert("아무 것도 없는");
	// confirm("확인/취소 있는");
	// prompt("뭔가 쓸 수 있는");
	/*var really = confirm("회원탈퇴"); // 확인 true, 취소 false
	if (really) {
		location.href = "ByeController";
	}*/
	var txt = prompt("탈퇴를 원하시면 \"회원탈퇴\" 를 입력해주세요");
	if (txt == "회원탈퇴") {
		location.href = "ByeController";
	}
}

function goNoticeDetail(bn) {
	location.href = "NoticeDetailController?bn=" + bn; // bn_no (게시글 조회용도)
}

function writeNoticeReply() {
	var noField = document.getElementById("bn_no"); // detail.jsp의 댓글 기능에서 가져옴 id="" 속의 값을 가져오는 것
	var txtField = document.getElementById("txt");
	var tokenField = document.getElementById("token");

	if (!isEmpty(txtField)) {
		location.href = "NoticeReplyWriteController?token=" + tokenField.value + "&no=" + noField.value + "&txt=" + txtField.value;
	}
}