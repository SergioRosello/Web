function validateForm() {
	var x = document.forms["formulario"]["name"].value;
	if (!x) {
		document.forms["formulario"]["name"].focus();
		alert("Debe rellenar el campo de texto");
		return false;
	}
	return true;
}


function check(){
	var checkbox = document.forms["formulario"]["seleccionMultiple"].options;

	for (var i = 0, len = checkbox.length; i < len; i++) {
		if (checkbox[i].selected) {
			return true;
		}
	}
	document.forms["formulario"]["seleccionMultiple"].focus();
	alert("Debe elegir una de las opciones disponibles");

	return false;
}


function checkRad(){
	var radios = document.getElementsByName("rad");

	for (var i = 0, len = radios.length; i < len; i++) {
		if (radios[i].checked) {
			return true;
		}
	}
	radios[0].focus();
	alert("Debe marcar una de las opciones");
	
	return false;
}
