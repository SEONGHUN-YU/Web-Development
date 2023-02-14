// front-end 개발자꺼임 <- 헷갈리지 말 것

function check() {
	var nameBox = document.f.name;
	var hieghtBox = document.f.height;
	var weightBox = document.f.weight;
	var imgBOX = document.f.img;

	if (isEmpty(nameBox)) {
		alert("이름 확인");
		nameBox.value = "";
		nameBox.focus();
		return false;
	}

	if (isEmpty(hieghtBox) || isNotNumber(hieghtBox) || hieghtBox.value < 3) {
		alert("키 확인");
		hieghtBox.value = "";
		hieghtBox.focus();
		return false;
	}

	if (isEmpty(weightBox) || isNotNumber(weightBox)) {
		alert("몸무게 확인");
		weightBox.value = "";
		weightBox.focus();
		return false;
	}

	if (isEmpty(imgBOX) || (compareType(imgBOX, "png") && compareType(imgBOX, "jpg") && compareType(imgBOX, "gif"))) {
		alert("이미지 확인");
		imgBOX.value = "";
		imgBOX.focus();
		return false;
	}
	return true;
}