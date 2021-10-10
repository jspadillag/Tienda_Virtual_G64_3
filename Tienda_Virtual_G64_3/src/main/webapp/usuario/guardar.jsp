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
<title>Agregar</title>
</head>
<body>
	<h1>Agregar Usuario</h1>
	<div class="mx-auto" style="width: 700px;" >
		<form class="row g-3 needs-validation">
			<div class="col-md-6">
				<label for="inputCedula" class="form-label">Cédula</label> <input
					type="text" class="form-control" id="inputCedula"
					name="cedula_usuario" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese la cédula.</div>
			</div>

			<div class="col-md-6">
				<label for="inputUsuario" class="form-label">Usuario</label> <input
					type="text" class="form-control" id="inputUsuario" name="usuario"
					aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el usuario.</div>
			</div>
			<div class="col-md-7">
				<label for="inputNombreC" class="form-label">Nombre completo</label>
				<input type="text" class="form-control" id="inputNombreC"
					name="nombre_usuario" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el nombre.</div>
			</div>
			<div class="col-md-5">
				<label for="inputContraseña" class="form-label">Contraseña</label> <input
					type="text" class="form-control" id="inputContrasena"
					name="password" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese la contraseña.
				</div>
			</div>
			<div class="col-12">
				<label for="inputCorreo" class="form-label">Correo
					electrónico</label> <input type="email" class="form-control"
					id="inputCorreo" placeholder="usuario@dominio.com"
					name="email_usuario" aria-describedby="inputGroupPrepend" required>
				<div class="invalid-feedback">Por favor ingrese el correo
					electrónico.</div>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary" onclick="guardar()">Agregar</button>
				<button type="reset" class="btn btn-primary" onclick="location.href='/usuario/listar.jsp'">Cancelar</button>
			</div>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/js/guardar.js"></script>
</body>
</html>