function buscar() {
	cedula = document.getElementById("inputCedula").value;
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/cliente/" + cedula,
		success: function(cliente) {
			$('#labelUsuario').val(cliente.nombre_cliente);
		}
	});

	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/venta/contadorventa",
		success: function(consecutivo) {
			$('#labelConsec').val(consecutivo);
		}
	});
}

function buscarProducto(numero) {
	var codigo;
	if (numero == 1) {
		codigo = document.getElementById("inputCodigo").value;
	} else if (numero == 2) {
		codigo = document.getElementById("inputCodigoDos").value;
	} else if (numero == 3) {
		codigo = document.getElementById("inputCodigoTres").value;
	}
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/producto/" + codigo,
		success: function(producto) {
			if (numero == 1) {
				$('#labelNombre').val(producto.nombre_producto);
				$('#labelIva1').val(producto.ivacompra);
			} else if (numero == 2) {
				$('#labelNombreDos').val(producto.nombre_producto);
				$('#labelIva2').val(producto.ivacompra);
			} else if (numero == 3) {
				$('#labelNombreTres').val(producto.nombre_producto);
				$('#labelIva3').val(producto.ivacompra);
			}

		}
	});
}


function onChangeCant(numero) {
	var codigo;
	if (numero == 1) {
		codigo = document.getElementById("inputCodigo").value;
	} else if (numero == 2) {
		codigo = document.getElementById("inputCodigoDos").value;
	} else if (numero == 3) {
		codigo = document.getElementById("inputCodigoTres").value;
	}
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/producto/" + codigo,
		success: function(producto) {
			if (numero == 1) {
				var cantidad = document.getElementById("labelCantidad1").value;
				$('#labelTotal1').val(producto.precio_venta * cantidad);
			} else if (numero == 2) {
				var cantidad = document.getElementById("labelCantidad2").value;
				$('#labelTotal2').val(producto.precio_venta * cantidad);
			} else if (numero == 3) {
				var cantidad = document.getElementById("labelCantidad3").value;
				$('#labelTotal3').val(producto.precio_venta * cantidad);
			}

		}
	});
}

function confirmar() {
	var totalVenta = Number(document.getElementById("labelTotal1").value) +
		Number(document.getElementById("labelTotal2").value) +
		Number(document.getElementById("labelTotal3").value);

	$('#labelTotalV').val(totalVenta);

	var totalIva = (document.getElementById("labelTotal1").value * document.getElementById("labelIva1").value / 100) +
		(document.getElementById("labelTotal2").value * document.getElementById("labelIva2").value / 100) +
		(document.getElementById("labelTotal3").value * document.getElementById("labelIva3").value / 100);

	$('#labelTotalIva').val(totalIva);

	var totalConIva = totalVenta + totalIva;

	$('#labelTotalconIva').val(totalConIva);
}

function guardar() {
	var venta = {
		codigo_venta: document.getElementById("labelConsec").value,
		cedula_cliente: document.getElementById("inputCedula").value,
		cedula_usuario: 111111, // document.getElementById("inputCedula").value,
		iva_venta: document.getElementById("labelTotalIva").value,
		total_venta: document.getElementById("labelTotalV").value,
		valor_venta: document.getElementById("labelTotalconIva").value
	};
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/api/venta",
		dataType: "json",
		contentType: 'application/json',
		data: JSON.stringify(venta),
		success: function(data) {
			console.log('Venta guardada');
			alert('Venta guardada');
			
			var detalleVenta = {
				cantidad_producto: document.getElementById("labelCantidad1").value,
				codigo_producto: document.getElementById("inputCodigo").value,
				codigo_venta: document.getElementById("labelConsec").value,
				valor_total: document.getElementById("labelTotalV").value,
				valor_venta: document.getElementById("labelTotalconIva").value,
				valoriva: document.getElementById("labelTotalIva").value
			};
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/detalleventas",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(detalleVenta),
				success: function(data) {
					console.log('DetalleVenta guardada 1');
				}
			});
			
			var detalleVenta2 = {
				cantidad_producto: document.getElementById("labelCantidad2").value,
				codigo_producto: document.getElementById("inputCodigoDos").value,
				codigo_venta: document.getElementById("labelConsec").value,
				valor_total: document.getElementById("labelTotalV").value,
				valor_venta: document.getElementById("labelTotalconIva").value,
				valoriva: document.getElementById("labelTotalIva").value
			};
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/detalleventas",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(detalleVenta2),
				success: function(data) {
					console.log('DetalleVenta guardada 2');
				}
			});
			
			var detalleVenta3 = {
				cantidad_producto: document.getElementById("labelCantidad3").value,
				codigo_producto: document.getElementById("inputCodigoTres").value,
				codigo_venta: document.getElementById("labelConsec").value,
				valor_total: document.getElementById("labelTotalV").value,
				valor_venta: document.getElementById("labelTotalconIva").value,
				valoriva: document.getElementById("labelTotalIva").value
			};
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/detalleventas",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(detalleVenta3),
				success: function(data) {
					console.log('DetalleVenta guardada 3');
				}
			});
			location.reload();
		}
	});
}