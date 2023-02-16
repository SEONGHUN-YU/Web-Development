// JS는 쓸 일이 많은데 주제별로 정리하는 거보다
// 그냥 프로젝트마다 1개정도의 파일로만 정리하는 편이 낫다
// 반대로 CSS는 한 페이지당 하나씩 해도 나쁘지 않다
function calcCheck() {
	var xBox = document.calcForm.xx;
	var yBox = document.calcForm.yy;

	if (isEmpty(xBox) || isNotNumber(xBox) || isEmpty(yBox) || isNotNumber(yBox)) {
		alert("양식이 다름");
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
		alert("규칙에 어긋남");
		userNumber.value = "";
		userNumber.focus();
		return false;
	}
	return true;
}