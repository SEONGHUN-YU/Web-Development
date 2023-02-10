function check() {

	var picBox = document.f.pic;
	var widthBox = document.f.width;
	var heightBox = document.f.height;

	if (isEmpty(picBox) ||
		compareType(picBox, "png") &&
		compareType(picBox, "gif") &&
		compareType(picBox, "jpg")) {
		alert("사진을 넣으세요");
		picBox.value = "";
		picBox.focus();
		return false;
	}
	if (isEmpty(widthBox) || isNotNumber(widthBox)) {
		alert("가로크기를 입력하세요");
		widthBox.value = "";
		widthBox.focus();
		return false;
	}
	if (isEmpty(heightBox) || isNotNumber(heightBox)) {
		alert("세로크기를 입력하세요");
		heightBox.value = "";
		heightBox.focus();
		return false;
	}
	return true;
}