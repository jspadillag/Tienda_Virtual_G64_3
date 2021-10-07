<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link href="/css/listar.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
<h1>Agregar productos</h1>
	<div style="padding-left: 5px;">

		<div class="container">

			<div id="error" class="alert alert-danger visually-hidden"
				role="alert">Archivo vacio, extensión no válida o datos
				corruptos (El separador debe ser coma ",")</div>

			<div id="correcto" class="alert alert-success visually-hidden"
				role="alert">Productos importados desde CSV con éxito</div>

			<form id="form1">
				<div>
					<label for="formFileLg" class="form-label">Seleccione el
						archivo CSV con el inventario de productos</label> <input
						class="form-control form-control-lg" id="archivo" type="file"
						accept=".csv"> <br> <br>
					<button type="button" class="btn btn-success"
						onclick="subirArchivo()">Subir archivo</button>
				</div>
				<br> <br>
			</form>

			<div class="container">
				<div class="row">

					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/listarproductos'">
						<i class="fas fa-search"></i> Listar todos los Productos
					</button>
				</div>
			</div>



			<div class="row">
				<div class="col align-self-center" id="productosinfo"></div>
			</div>
			
			
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
				crossorigin="anonymous"></script>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<script src="/js/producto/guardarListarProducto.js"></script>
</body>
</html>