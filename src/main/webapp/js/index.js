

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
		ingresar();
		return false;
	});
})();



function ingresar() {
	var usuario = document.getElementById("usuario").value;
	var password = document.getElementById("password").value;

	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/usuario",
		success: function(usuarios) {
			var usuarioEncontrado = false;

			usuarios.forEach((response) => {
				if (response.usuario === usuario) {
					if (response.password === password) {
						usuarioEncontrado = true;
						return;
					}
				}
			});

			if (usuarioEncontrado) {
				window.location.href = "/usuario/listar.jsp"
			} else {
				alert("Usuario o contraseña incorrecta");
			}
		}
	})

	console.log("usuario", usuario);
	console.log("contrasena", password);
}