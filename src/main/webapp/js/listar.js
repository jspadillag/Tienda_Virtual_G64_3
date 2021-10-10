(function() {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/usuario",
		success: function(listado) {
			listado.forEach((item) => {
				lista = document.getElementById("myTable");
				var tr = document.createElement("tr");
				var columna1 = document.createElement("td");
				columna1.innerHTML = item.cedula_usuario;
				var columna2 = document.createElement("td");
				columna2.innerHTML = item.email_usuario;
				var columna3 = document.createElement("td");
				columna3.innerHTML = item.nombre_usuario;
				var columna4 = document.createElement("td");
				columna4.innerHTML = item.password;
				var columna5 = document.createElement("td");
				columna5.innerHTML = item.usuario;
				var columna6 = document.createElement("td");
				columna6.innerHTML = "<a class='btn-eliminar' onclick='eliminar(" + item.cedula_usuario + ")'>Eliminar</a>";
				var columna7 = document.createElement("td");
				columna7.innerHTML = "<a class='btn-editar' onclick='editar("+item.cedula_usuario+")'>Editar</a>";

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
	window.location.href ="/usuario/editar.jsp"
}

function eliminar(cedula) {
	$.ajax({
		type: "DELETE",
		url: "http://localhost:8080/api/usuario/" + cedula,
		success: function() {
			window.location.href = "/usuario/listar.jsp";
		}
	})
}

$('li').click(function() {
  $(this).addClass('active').siblings().removeClass('active');
});


