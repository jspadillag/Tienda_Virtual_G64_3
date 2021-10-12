<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Grupo 64</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link href="./css/index.css" rel="stylesheet">
</head>
<body>
<div class="contenedor">
<form id="form" class="row g-3 needs-validation" novalidate>
<h1 class="text-center">Bienvenido</h1>
<div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="Usuario" id="usuario" required="required">
  <div class="invalid-feedback">
        Por favor ingrese el usuario.
      </div>
</div>

<div class="mb-3">
  <input type="password" class="form-control" placeholder="Contraseña" id="password" required="required">
  <div class="invalid-feedback">
        Por favor ingrese la contraseña.
      </div>
</div>

<br>
<div class="btn-button">
<button type="submit" class="btn btn-outline-primary">Ingresar</button>
 <button type="reset" class="btn btn-outline-primary">Cancelar</button>
</div>

</form>
</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="./js/index.js"></script>
</body>
</html>