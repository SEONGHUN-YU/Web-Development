function check() {
	var nameBox = document.f.name;
	var priceBox = document.f.price;

	if (isEmpty(nameBox) || isEmpty(priceBox) || isNotNumber(priceBox)||!notContainsLetter(priceBox, ".")) {
		alert("입력 확인");
		nameBox.value = "";
		priceBox.value = "";
		nameBox.focus();
		return false;
	}
	return true;
}