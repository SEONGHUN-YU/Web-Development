function check() {

	var picBox = document.f.pic;
	var widthBox = document.f.width;
	var heightBox = document.f.height;

	if (isEmpty(picBox) ||
		compareType(picBox, "png") &&
		compareType(picBox, "gif") &&
		compareType(picBox, "jpg")) {
		alert("������ ��������");
		picBox.value = "";
		picBox.focus();
		return false;
	}
	if (isEmpty(widthBox) || isNotNumber(widthBox)) {
		alert("����ũ�⸦ �Է��ϼ���");
		widthBox.value = "";
		widthBox.focus();
		return false;
	}
	if (isEmpty(heightBox) || isNotNumber(heightBox)) {
		alert("����ũ�⸦ �Է��ϼ���");
		heightBox.value = "";
		heightBox.focus();
		return false;
	}
	return true;
}