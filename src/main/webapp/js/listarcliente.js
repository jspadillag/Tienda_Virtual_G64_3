(function() {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/cliente",
		success: function(listado) {
			listado.forEach((item) => {
				lista = document.getElementById("myTablec");
				var tr = document.createElement("tr");
				var columna1 = document.createElement("td");
				columna1.innerHTML = item.cedula_cliente;
				var columna2 = document.createElement("td");
				columna2.innerHTML = item.email_cliente;
				var columna3 = document.createElement("td");
				columna3.innerHTML = item.nombre_cliente;
				var columna4 = document.createElement("td");
				columna4.innerHTML = item.telefono_cliente;
				var columna5 = document.createElement("td");
				columna5.innerHTML = item.direccion_cliente;
				var columna6 = document.createElement("td");
				columna6.innerHTML = "<a class='btn-eliminar' onclick='eliminar(" + item.cedula_cliente + ")'>Eliminar</a>";
				var columna7 = document.createElement("td");
				columna7.innerHTML = "<a class='btn-editar' onclick='editar("+item.cedula_cliente+")'>Editar</a>";

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

function editar (cedula){
	localStorage.setItem('cedula', cedula);
	window.location.href ="/cliente/editarcliente.jsp"
}

function eliminar(cedula) {
	$.ajax({
		type: "DELETE",
		url: "http://localhost:8080/api/cliente/" + cedula,
		success: function() {
			window.location.href = "/cliente/listarcliente.jsp";
		}
	})
}