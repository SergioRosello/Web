function validateForm() {
	var x = document.forms["formulario"]["name"].value;
	if (!x) {
		alert("Debe rellenar el campo de texto");
		document.forms["formulario"]["name"].focus();
		return false;
	}
	return true;
}


function check{
	var checkbox = document.forms["formulario"]["seleccion multiple"];

	for (var i = 0, len = checkbox.length; i < len; i++) {
		if (checkbox[i].checked) {
			return true;
		}
	}
	alert("Debe elegir una de las opciones disponibles");
	for (var i = 0, len = checkbox.length; i < len; i++) {
		checkbox[i].focus();
	}
	return false;
}


function checkRad(){
	var radios = document.getElementsByName("rad");

	for (var i = 0, len = radios.length; i < len; i++) {
		if (radios[i].checked) {
			return true;
		}
	}
	alert("Debe marcar una de las opciones");
	for (var i = 0, len = radios.length; i < len; i++) {
		radios[i].focus();
	}
	return false;
}
