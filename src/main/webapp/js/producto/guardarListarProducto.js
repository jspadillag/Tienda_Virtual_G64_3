function subirArchivo() {

	try {
		var csvFile = document.getElementById("archivo");
		var input = csvFile.files[0];
		var reader = new FileReader();

		reader.onload = function(e) {

			var text = e.target.result;
			var arrayLineas = text.split("\n");
			var xhr = new XMLHttpRequest();
			xhr.open("DELETE", "http://localhost:8080/api/producto", true);
			xhr.send();

			for (var i = 0; i < arrayLineas.length; i += 1) {
				var arraydatos = arrayLineas[i].split(",");

				if (arrayLineas[i] == "") {
					continue;
				}

				for (var j = 0; j < arraydatos.length; j += 1) {
					console.log(i + " " + j + "->" + arraydatos[j]);
				}

				var formData = new FormData();
				formData.append("codigo_producto", arraydatos[0]);
				formData.append("ivacompra", arraydatos[1]);
				formData.append("nitproveedor", arraydatos[2]);
				formData.append("nombre_producto", arraydatos[3]);
				formData.append("precio_compra", arraydatos[4]);
				formData.append("precio_venta", arraydatos[5]);
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "http://localhost:8080/api/producto");
				xhr.send(formData);
			}

			var element = document.getElementById("error");
			element.classList.add("visually-hidden");
			var element2 = document.getElementById("correcto");
			element2.classList.remove("visually-hidden");

			document.getElementById("archivo").value = "";

			window.alert("Archivo cargado con exito, se cargaron " + arrayLineas.length + " productos");

			load_productos();


		};

		reader.readAsText(input);
	} catch (error) {
		var element = document.getElementById("error");
		element.classList.remove("visually-hidden");
		var element2 = document.getElementById("correcto");
		element2.classList.add("visually-hidden");

		document.getElementById("archivo").value = "";
	}
}


function load_productos() {
	var baseurl = "http://localhost:8080/api/producto";
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", baseurl, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
			var productos = JSON.parse(xmlhttp.responseText);
			var tbltop = "<table class='table table-dark table-striped'><tr><th>Codigo Producto</th><th>Iva Compra</th><th>Nit Proveedor</th><th>Nombre Producto</th><th>Precio Compra</th><th>Precio Venta</th></tr>";
			var main = "";
			for (i = 0; i < productos.length; i++) {
				main += "<tr><td>" + productos[i].codigo_producto
					+ "</td><td>" + productos[i].ivacompra + "%"
					+ "</td><td>" + productos[i].nitproveedor
					+ "</td><td>" + productos[i].nombre_producto
					+ "</td><td>" + productos[i].precio_compra
					+ "</td><td>" + productos[i].precio_venta +
					"</td></tr>";
			}
			var tblbottom = "</table>";
			var tbl = tbltop + main + tblbottom;
			document.getElementById("productosinfo").innerHTML = tbl;
		}
	}; 
	xmlhttp.send();
}