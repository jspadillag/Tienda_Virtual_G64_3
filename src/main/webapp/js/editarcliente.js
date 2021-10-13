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
	const cedulaUser = localStorage.getItem('cedula');
	mostrar(cedulaUser);
})();

function mostrar(cedulaUser) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/cliente/" + cedulaUser,
		success: function(usuario) {
			$('#inputCedula').val(usuario.cedula_cliente);
			$('#inputUsuario').val(usuario.nombre_cliente);
			$('#inputDireccion').val(usuario.direccion_cliente);
			$('#inputTelefono').val(usuario.telefono_cliente);
			$('#inputCorreo').val(usuario.email_cliente);
		}
	});
}

function editar() {
	var usuario = {
		cedula_cliente: document.getElementById("inputCedula").value,
		email_cliente: document.getElementById("inputCorreo").value,
		nombre_cliente: document.getElementById("inputUsuario").value,
		direccion_cliente: document.getElementById("inputDireccion").value,
		telefono_cliente: document.getElementById("inputTelefono").value
	};
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/api/cliente",
		dataType: "json",
		contentType: 'application/json',
		data: JSON.stringify(usuario),
		success: function(data) {
			window.location.href = "/cliente/listarcliente.jsp";
		}
	});
}