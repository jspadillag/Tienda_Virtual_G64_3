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
	
	const nitProveedor = localStorage.getItem('nitproveedor');
	mostrar(nitProveedor);
})();

function editar() {
	var proveedores = {
		nitproveedor: document.getElementById("inputNitproveedor").value,
		ciudad_proveedor: document.getElementById("inputCiudad_proveedor").value,
		direccion_proveedor: document.getElementById("inputDireccion_proveedor").value,
		nombre_proveedor: document.getElementById("inputNombre_proveedor").value,
		telefono_proveedor: document.getElementById("inputTelefono_proveedor").value
	};
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/api/proveedores",
		dataType: "json",
		contentType: 'application/json',
		data: JSON.stringify(proveedores),
		success: function(response) {
			window.location.href = "/Proveedores/listar.jsp"
		}
	});
}


function mostrar(nitProveedor) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/proveedores/" + nitProveedor,
		success: function(proveedor) {
			$('#inputNitproveedor').val(proveedor.nitproveedor);
			$('#inputCiudad_proveedor').val(proveedor.ciudad_proveedor);
			$('#inputDireccion_proveedor').val(proveedor.direccion_proveedor);
			$('#inputNombre_proveedor').val(proveedor.nombre_proveedor);
			$('#inputTelefono_proveedor').val(proveedor.telefono_proveedor);
		}
	});
}
