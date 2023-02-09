function test() {
	// int[] ar = {1, 2, 3}; // JS에서는 배열 쓰고 싶어도 형식 신경 안 쓰고 var
	var ar = [1213, "ㅋ", 12, 563];
	alert(ar[1]);

	// DOg d = new Dog();
	// d.setName("후추");
	// System.out.println(d.getName());
	var d = { name: "후추", age: 3 }; // {} <- 이게 객체임
	alert(d);
	alert(d.name);
}
// XML -> JSON
function test2() {
	var ar = [
		{ name: "홍길동", age: 20 },
		{ name: "김길동", age: 30 },
		{ name: "이길동", age: 40 }
	];
	for (var i = 0; i < ar.length; i++) {
		alert(ar[i].name + " : " + ar[i].age);
	}
}

function test3(){
	// 정통JS로는 유효성 검사랑 GET방식 요청 정도 해보고
	// 나머지 방대한 기능 : jQuery or react
	
	location.href = "https://www.naver.com"; // JS로 하는 GET방식 요청
	
	// JavaScript : 웹페이지 이벤트 처리
	// 문법이 좀 길다 + interpreter방식
	// 개발자들에게 외면 받은 면이 좀 있다
	
	// 전통적인 스타일  : 정통JS < jQuery
	// 차세대 스타일	: 정통JS < react/vue
	// -----------------------------
	// original JS는 좀...
	
	// jQuery : JavaScript 쓰기 편하게 해놓은 library <- jQuery가 나오면서 입장이 역전되었다, 정통 JS는 잘 안 씀
	//		Spring 7 : jQuery 3

	// react/vue : 웹 개발 구조 자체를 새로운 느낌
	//		Spring 3 : react/vue 7
}