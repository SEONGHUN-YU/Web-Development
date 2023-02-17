function testCheck() {
	var testInput = document.testForm.yeah;

	if (isEmpty(testInput)) {
		alert("입력 필수");
		testInput.value = "";
		testInput.focus();
		return false;
	}
	return true;
}

function calcCheck() {
	var calcBox = document.calcForm.calcValue;

	if (isEmpty(calcBox)) {
		alert("입력 필수");
		calcBox.value = "";
		calcBox.focus();
		return false;
	}
	return true;
}