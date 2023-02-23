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

// 유효성 검사를 왜 JS에서 할까?
//		Java DAO는 그거 아니라도 할 일 많고
//		사용자의 브라우저 JS도 검사할 줄 아니까 굳이 서버까지 가져가지 않고 여기서 해버리는 것
//	지금 주제는 로그인
//	DAO에서 DB에 저장된 id/pw, 입력한 id/pw 비교
//	이 비교하는 과정 자체가 유효성 검사가 아닐까?
//	=> 따라서 로그인시에는 JS에서 빡세게 검사 안 해도 됨

function loginCheck() {
	var idField = document.loginForm.id;
	var pwField = document.loginForm.pw;

	if (isEmpty(idField) || isEmpty(pwField)) {
		alert("ID, PW 입력 필수");
		idField.value = "";
		pwField.value = "";
		idField.focus();
		return false;
	}
	return true;
}