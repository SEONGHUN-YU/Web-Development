function regCheck() {
	var idBox = document.joinForm.id;
	var pwBox = document.joinForm.pw;
	var pwchkBox = document.joinForm.pwchk;
	var nameBox = document.joinForm.name;
	var photoBox = document.joinForm.photo;

	if (isEmpty(idBox)
		|| notAllowedLetter(idBox)) {
		alert("ID 확인");
		idBox.value = "";
		idBox.focus();
		return false;
	}

	if (isEmpty(pwBox)
		|| notContainsLetter(pwBox, "123456789")
		|| notEquals(pwBox, pwchkBox)) {
		alert("PW 확인");
		pwBox.value = "";
		pwchkBox.value = "";
		pwBox.focus();
		return false;
	}

	if (isEmpty(nameBox)) {
		alert("이름 필수");
		idBox.focus();
		return false;
	}

	// 생일은 select로 처리해서 valid check가 필요 없고
	// 프사는 필수, 사진파일만 업로드 하도록 검사
	
	if (isEmpty(photoBox)
		|| (compareType(photoBox, "jpg")
			&& compareType(photoBox, "png")
			&& compareType(photoBox, "gif"))) {
		alert("파일 확인");
		photoBox.value = "";
		return false;
	}

	return true;
}
