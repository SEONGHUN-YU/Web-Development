// JS�� �� ���� ������ �������� �����ϴ� �ź���
// �׳� ������Ʈ���� 1�������� ���Ϸθ� �����ϴ� ���� ����
// �ݴ�� CSS�� �� �������� �ϳ��� �ص� ������ �ʴ�
function calcCheck() {
	var xBox = document.calcForm.xx;
	var yBox = document.calcForm.yy;

	if (isEmpty(xBox) || isNotNumber(xBox) || isEmpty(yBox) || isNotNumber(yBox)) {
		alert("����� �ٸ�");
		xBox.value = "";
		yBox.value = "";
		xBox.focus();
		return false;
	}
	return true;
}

function baseballCheck() {
	var userNumber = document.baseballForm.user;

	if (isEmpty(userNumber) || isNotNumber(userNumber) || userNumber.value < 100
		|| userNumber.value.substr(0, 1) == userNumber.value.substr(1, 1)
		|| userNumber.value.substr(0, 1) == userNumber.value.substr(2, 1)
		|| userNumber.value.substr(1, 1) == userNumber.value.substr(2, 1)) {
		alert("��Ģ�� ��߳�");
		userNumber.value = "";
		userNumber.focus();
		return false;
	}
	return true;
}