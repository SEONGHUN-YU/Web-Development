function test() {
	// int[] ar = {1, 2, 3}; // JS������ �迭 ���� �; ���� �Ű� �� ���� var
	var ar = [1213, "��", 12, 563];
	alert(ar[1]);

	// DOg d = new Dog();
	// d.setName("����");
	// System.out.println(d.getName());
	var d = { name: "����", age: 3 }; // {} <- �̰� ��ü��
	alert(d);
	alert(d.name);
}
// XML -> JSON
function test2() {
	var ar = [
		{ name: "ȫ�浿", age: 20 },
		{ name: "��浿", age: 30 },
		{ name: "�̱浿", age: 40 }
	];
	for (var i = 0; i < ar.length; i++) {
		alert(ar[i].name + " : " + ar[i].age);
	}
}

function test3(){
	// ����JS�δ� ��ȿ�� �˻�� GET��� ��û ���� �غ���
	// ������ ����� ��� : jQuery or react
	
	location.href = "https://www.naver.com"; // JS�� �ϴ� GET��� ��û
	
	// JavaScript : �������� �̺�Ʈ ó��
	// ������ �� ��� + interpreter���
	// �����ڵ鿡�� �ܸ� ���� ���� �� �ִ�
	
	// �������� ��Ÿ��  : ����JS < jQuery
	// ������ ��Ÿ��	: ����JS < react/vue
	// -----------------------------
	// original JS�� ��...
	
	// jQuery : JavaScript ���� ���ϰ� �س��� library <- jQuery�� �����鼭 ������ �����Ǿ���, ���� JS�� �� �� ��
	//		Spring 7 : jQuery 3

	// react/vue : �� ���� ���� ��ü�� ���ο� ����
	//		Spring 3 : react/vue 7
}