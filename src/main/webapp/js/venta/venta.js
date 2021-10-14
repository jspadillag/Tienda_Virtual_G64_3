
/*function mostrar(cedula) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/cliente/" + cedula,
		success: function(cliente) {
			$('#labelUsuario').val(cliente.nombre_cliente);
		}
	});
}

function buscar() {
	cedula = document.getElementById("inputCedula").value;
	mostrar(cedula);
*/


function buscar() {
	cedula = document.getElementById("inputCedula").value;
		$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/cliente/" + cedula,
		success: function(cliente) {
			$('#labelUsuario').val(cliente.nombre_cliente);
		}
	});
}


/*function mostrarProducto(codigo) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/producto/" + codigo,
		success: function(producto) {
			$('#labelNombre').val(producto.nombre_producto);
			$('#labelNombre2').val(producto.nombre_producto);
			$('#labelNombre3').val(producto.nombre_producto);
		}
	});
}*/

function buscarProducto(numero) {
	var codigo;	
	if(numero == 1){
		codigo = document.getElementById("inputCodigo").value;
	}else if (numero == 2) {
		codigo = document.getElementById("inputCodigoDos").value;
		}else if (numero == 3) {
			codigo = document.getElementById("inputCodigoTres").value;
			}
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/producto/" + codigo,
		success: function(producto) {
			if(numero == 1) {
				$('#labelNombre').val(producto.nombre_producto);
			}else if(numero == 2) {
				$('#labelNombreDos').val(producto.nombre_producto);
			}else if(numero == 3) {
				$('#labelNombreTres').val(producto.nombre_producto);
				}
			
		}
	});
}