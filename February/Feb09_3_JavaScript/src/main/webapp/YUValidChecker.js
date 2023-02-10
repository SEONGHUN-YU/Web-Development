function isEmpty(input) {
	return !input.value;
}
function notAllowedLetter(input) {
	var alpha = "123456789@-_.abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	for (var i = 0; i < input.value.length; i++) {
		if (alpha.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
}
function notContainsLetter(input, set) {
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}
function isNotNumber(input) {
	return (input.value.indexOf(" ") != -1 || isNaN(input.value));
}
function notEquals(input1, input2) {
	return input1.value != input2.value;
}
function lengthOfLetter(input, length) {
	if (input.value.length < length) {
		return true;
	}
}
function compareType(input, type) {
	type = "." + type;
	return input.value.toLowerCase().indexOf(type) == -1;
}