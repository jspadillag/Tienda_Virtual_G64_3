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
		url: "http://localhost:8080/api/usuario/" + cedulaUser,
		success: function(usuario) {
			$('#inputCedula').val(usuario.cedula_usuario);
			$('#inputUsuario').val(usuario.usuario);
			$('#inputNombreC').val(usuario.nombre_usuario);
			$('#inputContrasena').val(usuario.password);
			$('#inputCorreo').val(usuario.email_usuario);
		}
	});
}

function editar() {
	var usuario = {
		cedula_usuario: document.getElementById("inputCedula").value,
		email_usuario: document.getElementById("inputCorreo").value,
		usuario: document.getElementById("inputUsuario").value,
		password: document.getElementById("inputContrasena").value,
		nombre_usuario: document.getElementById("inputNombreC").value
	};
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/api/usuario",
		dataType: "json",
		contentType: 'application/json',
		data: JSON.stringify(usuario),
		success: function(data) {
			window.location.href = "/usuario/listar.jsp";
		}
	});
}






