<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Inicio</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link href="/css/listar.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
<h1>Listado de Usuarios</h1>
<div class="btn-button">
<button type="button" class="btn btn-primary" onclick="location.href='/usuario/guardar.jsp'">Agregar usuario</button>
</div>
<div class="contenedor">
<table class="table table-sm">
		<thead>
			<tr>
<th>C�dula</th>
<th>Correo</th>
<th>Nombre</th>
<th>Contrase�a</th>
<th>Usuario</th>
<th colspan = "2">Acciones</th>
</tr>
		</thead>
		<tbody id="myTable">
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
	<script src="/js/listar.js"></script>
</html>