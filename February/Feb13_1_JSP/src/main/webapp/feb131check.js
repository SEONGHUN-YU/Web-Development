function check() {

	var xInput = document.f.xxx;
	var yInput = document.f.yyy;

	if (isEmpty(xInput) || isNotNumber(xInput) || isEmpty(yInput)
		|| isNotNumber(yInput)) {
		alert("숫자만 쓰세요");
		xInput.value = "";
		yInput.value = "";
		xInput.focus();
		return false;
	}
	return true;
}