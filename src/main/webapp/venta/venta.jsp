<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<title>Ventas</title>
</head>
<body>
	<jsp:include page="/menu/menu.jsp"></jsp:include>
	<h1>Ventas</h1>
	<div class="mx-auto" style="width: 700px;">
		<form id="form" class="row g-3 needs-validation">
			<div style="display: flex; align-items: center;" >
				<label class="form-label">Cédula</label> <input type="text"
					class="form-control" id="inputCedula" name="cedula_usuario"
					aria-describedby="inputGroupPrepend">
				<button type="button" onclick="buscar()" class="btn btn-success">Buscar</button>
				<label class="form-label">Usuario</label> <input type="text"
					class="form-control" id="labelUsuario" name="nombre_usuario"
					aria-describedby="inputGroupPrepend">
			</div>
			<div style="display: flex; align-items: center;">
				<label class="form-label">Código del producto</label> <input type="text"
					class="form-control" id="inputCodigo" name="codigo_producto"
					aria-describedby="inputGroupPrepend">
				<button type="button" onclick="buscarProducto()" class="btn btn-success">Buscar</button>
				<label class="form-label">Producto</label> <input type="text"
					class="form-control" id="labelNombre" name="nombre_producto"
					aria-describedby="inputGroupPrepend">
			</div>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="/js/venta/venta.js"></script>
</body>
</html>