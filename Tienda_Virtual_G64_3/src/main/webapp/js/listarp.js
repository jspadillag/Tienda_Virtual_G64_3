(function() {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/proveedor",
		success: function(listado) {
			listado.forEach((item) => {
				lista = document.getElementById("myTable");
				var tr = document.createElement("tr");
				var columna1 = document.createElement("td");
				columna1.innerHTML = item.nitproveedor;
				var columna2 = document.createElement("td");
				columna2.innerHTML = item.ciudad_proveedor;
				var columna3 = document.createElement("td");
				columna3.innerHTML = item.direccion_proveedor;
				var columna4 = document.createElement("td");
				columna4.innerHTML = item.nombre_proveedor;
				var columna5 = document.createElement("td");
				columna5.innerHTML = item.telefono_proveedor;
				var columna6 = document.createElement("td");
				columna6.innerHTML = "<a class='btn-eliminar' onclick='eliminarp(" + item.nitproveedor + ")'>Eliminar</a>";
				var columna7 = document.createElement("td");
				columna7.innerHTML = "<a onclick='mostrarp(" + item.nitproveedor + ")'>Editar</a>";

				lista.appendChild(tr);
				tr.appendChild(columna1);
				tr.appendChild(columna2);
				tr.appendChild(columna3);
				tr.appendChild(columna4);
				tr.appendChild(columna5);
				tr.appendChild(columna6);
				tr.appendChild(columna7);
			})
		}
	});
})();

function eliminarp(nitproveedor) {
	$.ajax({
		type: "DELETE",
		url: "http://localhost:8080/api/proveedores/" + nitproveedor,
		success: function() {
			window.location.href = "/proveedores/listar.jsp"
		}
	})
}

function mostrarp(nitproveedor) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/proveedores/" + nitproveedor,
		success: function() {
			window.location.href = "/proveedores/listar.jsp"
		}
	})
}


