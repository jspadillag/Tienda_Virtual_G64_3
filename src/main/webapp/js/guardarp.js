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

function guardar() {
	var proveedores = {
		nitproveedor: document.getElementById("inputNitproveedor").value,
		ciudad_proveedor: document.getElementById("inputCiudad_proveedor").value,
		direccion_proveedor: document.getElementById("inputDireccion_proveedor").value,
		nombre_proveedor: document.getElementById("inputNombre_proveedor").value,
		telefono_proveedor: document.getElementById("inputTelefono_proveedor").value
	};
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/api/proveedores",
		dataType: "json",
		contentType: 'application/json',
		data: JSON.stringify(proveedores),
		success: function(response) {
			window.location.href = "/Proveedores/listar.jsp"
		}
	});
}
