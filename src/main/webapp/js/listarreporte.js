(function() {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/reporte",
		success: function(listado) {
			listado.forEach((item) => {
				lista = document.getElementById("myTablerep");
				var tr = document.createElement("tr");
				var columna1 = document.createElement("td");
				columna1.innerHTML = item.cedula_usuario;
				var columna2 = document.createElement("td");
				columna2.innerHTML = item.nombre_usuario;
				var columna3 = document.createElement("td");
				columna3.innerHTML = item.total_venta;
				
				lista.appendChild(tr);
				tr.appendChild(columna1);
				tr.appendChild(columna2);
				tr.appendChild(columna3);
								
			})
		}
	});
})();