function check() {
	var n = document.f.v;

	if (isEmpty(n) || isNotNumber(n) || n.value < 100
		|| n.value.substr(0, 1) == n.value.substr(1, 1)
		|| n.value.substr(0, 1) == n.value.substr(2, 1)
		|| n.value.substr(1, 1) == n.value.substr(2, 1)) {
		alert("규칙에 어긋남");
		n.value = "";
		n.focus();
		return false;
	}
	return true;
}