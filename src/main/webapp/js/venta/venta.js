var cedula;
var codigo;

function mostrar(cedula) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/usuario/" + cedula,
		success: function(usuario) {
			$('#labelUsuario').val(usuario.nombre_usuario);
		}
	});
}

function buscar() {
	cedula = document.getElementById("inputCedula").value;
	mostrar(cedula);
}

function mostrarProducto(codigo) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/producto/" + codigo,
		success: function(producto) {
			$('#labelNombre').val(producto.nombre_producto);
		}
	});
}

function buscarProducto() {
	codigo = document.getElementById("inputCodigo").value;
	mostrarProducto(codigo);
}