function check() {
	var numInput = document.ucForm.changevalue;
	
	if (isEmpty(numInput)||isNotNumber(numInput)){
		alert("?");
		numInput.value = "";
		numInput.focus();
		return false;
	}
	return true;
}