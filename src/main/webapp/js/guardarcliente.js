(function() {
	'use strict'
	var forms = document.querySelectorAll('.needs-validation')

	Array.prototype.slice.call(forms)
		.forEach(function(form) {
			form.addEventListener('submit', function(event) {
				if (!form.checkValidity()) {
					event.preventDefault()
					event.stopPropagation()
				}

				form.classList.add('was-validated')
			}, false)
		})

	$('#form').submit(function() {
		return false;
	});
})();

function guardarcliente() {
	var cliente = {
		cedula_cliente: document.getElementById("inputCedula").value,
		email_cliente: document.getElementById("inputCorreo").value,
		direccion_cliente: document.getElementById("inputDireccion").value,
		telefono_cliente: document.getElementById("inputTelefono").value,
		nombre_cliente: document.getElementById("inputUsuario").value
	};
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/api/cliente",
		dataType: "json",
		contentType: 'application/json',
		data: JSON.stringify(cliente),
		success: function(data) {
			window.location.href = "/cliente/listarcliente.jsp"
		}
	});
}
