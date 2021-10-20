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
	<link href="/css/listar.css" rel="stylesheet">
<title>editar Proveedor</title>
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
	<h1>Editar Proveedor</h1>
	<div class="mx-auto" style="width: 700px;" >
		<form class="row g-3 needs-validation" id="form">
			<div class="col-md-6">
				<label for="inputNitproveedor" class="form-label">Nit proveedor</label> <input
					type="text" class="form-control" id="inputNitproveedor"
					name="inputNitproveedor" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el Nit del proveedor.</div>
			</div>

			<div class="col-md-6">
				<label for="inputCiudad_proveedor" class="form-label">Ciudad Proveedor</label> <input
					type="text" class="form-control" id="inputCiudad_proveedor" name="Ciudad"
					aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese la ciudad del proveedor.</div>
			</div>
			<div class="col-md-6">
				<label for="inputDireccion_proveedor" class="form-label">Direccion del proveedor</label>
				<input type="text" class="form-control" id="inputDireccion_proveedor"
					name="direccion_proveedor" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese la dirección del proveedor.</div>
			</div>
			<div class="col-md-6">
				<label for="inputNombre_proveedor" class="form-label">Nombre proveedor</label> <input
					type="text" class="form-control" id="inputNombre_proveedor"
					name="nombre_proveedor" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el nombre proveedor.
				</div>
			</div>
			<div class="col-md-6">
				<label for="inputTelefono_proveedor" class="form-label">Telefono proveedor</label> <input 
					type="text" class="form-control" id="inputTelefono_proveedor" 
					name="telefono_proveedor" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el telefono del proveedor.</div>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary" onclick="editar()">Editar</button>
				<button type="reset" class="btn btn-primary" onclick="location.href='/Proveedores/listar.jsp'">Cancelar</button>
			</div>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/js/editarp.js"></script>
</body>
</html>