<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link href="/css/listar.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
<h1>Listado de Clientes</h1>
<div class="btn-button">
<button type="button" class="btn btn-primary" onclick="location.href='/cliente/guardarcliente.jsp'">Agregar cliente</button>
</div>
<div class="contenedor">
<table class="table table-sm">
		<thead>
			<tr>
<th>Cédula</th>
<th>Correo</th>
<th>Nombre</th>
<th>Telefono</th>
<th>Direccion</th>
<th colspan = "2">Acciones</th>
</tr>
		</thead>
		<tbody id="myTablec">
		</tbody>
</table>
</div>
</body>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/js/listarcliente.js"></script>
</html>