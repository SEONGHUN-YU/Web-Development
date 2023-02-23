function regCheck() {
	var idBox = document.joinForm.id;
	var pwBox = document.joinForm.pw;
	var pwchkBox = document.joinForm.pwchk;
	var nameBox = document.joinForm.name;
	var photoBox = document.joinForm.photo;

	if (isEmpty(idBox)
		|| notAllowedLetter(idBox)) {
		alert("ID Ȯ��");
		idBox.value = "";
		idBox.focus();
		return false;
	}

	if (isEmpty(pwBox)
		|| notContainsLetter(pwBox, "123456789")
		|| notEquals(pwBox, pwchkBox)) {
		alert("PW Ȯ��");
		pwBox.value = "";
		pwchkBox.value = "";
		pwBox.focus();
		return false;
	}

	if (isEmpty(nameBox)) {
		alert("�̸� �ʼ�");
		idBox.focus();
		return false;
	}

	// ������ select�� ó���ؼ� valid check�� �ʿ� ����
	// ����� �ʼ�, �������ϸ� ���ε� �ϵ��� �˻�

	if (isEmpty(photoBox)
		|| (compareType(photoBox, "jpg")
			&& compareType(photoBox, "png")
			&& compareType(photoBox, "gif"))) {
		alert("���� Ȯ��");
		photoBox.value = "";
		return false;
	}

	return true;
}

// ��ȿ�� �˻縦 �� JS���� �ұ�?
//		Java DAO�� �װ� �ƴ϶� �� �� ����
//		������� ������ JS�� �˻��� �� �ƴϱ� ���� �������� �������� �ʰ� ���⼭ �ع����� ��
//	���� ������ �α���
//	DAO���� DB�� ����� id/pw, �Է��� id/pw ��
//	�� ���ϴ� ���� ��ü�� ��ȿ�� �˻簡 �ƴұ�?
//	=> ���� �α��νÿ��� JS���� ������ �˻� �� �ص� ��

function loginCheck() {
	var idField = document.loginForm.id;
	var pwField = document.loginForm.pw;

	if (isEmpty(idField) || isEmpty(pwField)) {
		alert("ID, PW �Է� �ʼ�");
		idField.value = "";
		pwField.value = "";
		idField.focus();
		return false;
	}
	return true;
}