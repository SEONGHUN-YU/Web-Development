// front-end �����ڲ��� <- �򰥸��� �� ��

function check() {
	var nameBox = document.f.name;
	var hieghtBox = document.f.height;
	var weightBox = document.f.weight;
	var imgBOX = document.f.img;

	if (isEmpty(nameBox)) {
		alert("�̸� Ȯ��");
		nameBox.value = "";
		nameBox.focus();
		return false;
	}

	if (isEmpty(hieghtBox) || isNotNumber(hieghtBox) || hieghtBox.value < 3) {
		alert("Ű Ȯ��");
		hieghtBox.value = "";
		hieghtBox.focus();
		return false;
	}

	if (isEmpty(weightBox) || isNotNumber(weightBox)) {
		alert("������ Ȯ��");
		weightBox.value = "";
		weightBox.focus();
		return false;
	}

	if (isEmpty(imgBOX) || (compareType(imgBOX, "png") && compareType(imgBOX, "jpg") && compareType(imgBOX, "gif"))) {
		alert("�̹��� Ȯ��");
		imgBOX.value = "";
		imgBOX.focus();
		return false;
	}
	return true;
}