function goJoin() {
	location.href = "JoinController";
}

function logout() {
	location.href = "LoginController" // LogoutController�� ���� ���� ��
}

function goMemberInfo() {
	location.href = "MemberInfoController";
}

function bye() {
	// alert("�ƹ� �͵� ����");
	// confirm("Ȯ��/��� �ִ�");
	// prompt("���� �� �� �ִ�");
	/*var really = confirm("ȸ��Ż��"); // Ȯ�� true, ��� false
	if (really) {
		location.href = "ByeController";
	}*/
	var txt = prompt("Ż�� ���Ͻø� \"ȸ��Ż��\" �� �Է����ּ���");
	if (txt == "ȸ��Ż��") {
		location.href = "ByeController";
	}
}

function goNoticeDetail(bn) {
	location.href = "NoticeDetailController?bn=" + bn; // bn_no (�Խñ� ��ȸ�뵵)
}