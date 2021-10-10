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
<title>Agregar cliente</title>
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
	<h1>Agregar Cliente</h1>
	<div class="mx-auto" style="width: 700px;" >
	
		<form class="row g-3 needs-validation" id="form">
			<div class="col-md-6">
				<label for="inputCedula" class="form-label">Cédula</label> <input
					type="text" class="form-control" id="inputCedula"
					name="cedula_cliente" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese la cédula.</div>
			</div>

			<div class="col-md-6">
				<label for="inputUsuario" class="form-label">nombre</label> <input
					type="text" class="form-control" id="inputUsuario" name="nombre_cliente"
					aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el nombre.</div>
			</div>
			<div class="col-md-7">
				<label for="inputNombreC" class="form-label">Direccion</label>
				<input type="text" class="form-control" id="inputDireccion"
					name="direccion_cliente" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese la direccion.</div>
			</div>
			<div class="col-md-5">
				<label for="inputContraseña" class="form-label">Telefono</label> <input
					type="text" class="form-control" id="inputTelefono"
					name="telefono_cliente" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el telefono.
				</div>
			</div>
			<div class="col-12">
				<label for="inputCorreo" class="form-label">Correo
					electrónico</label> <input type="email" class="form-control"
					id="inputCorreo" placeholder="usuario@dominio.com"
					name="email_cliente" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el correo
					electrónico.</div>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary" onclick="guardarcliente()">Agregar</button>
				<button type="reset" class="btn btn-primary" onclick="location.href='/usuario/listarcliente.jsp'">Cancelar</button>
			</div>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/js/guardarcliente.js"></script>
</body>
</html>