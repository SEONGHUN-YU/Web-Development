function testCheck() {
	var testInput = document.testForm.yeah;

	if (isEmpty(testInput)) {
		alert("�Է� �ʼ�");
		testInput.value = "";
		testInput.focus();
		return false;
	}
	return true;
}

function calcCheck() {
	var calcBox = document.calcForm.calcValue;

	if (isEmpty(calcBox)) {
		alert("�Է� �ʼ�");
		calcBox.value = "";
		calcBox.focus();
		return false;
	}
	return true;
}