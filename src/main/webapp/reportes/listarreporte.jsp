<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte de ventas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link href="/css/listar.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
<h1>Reporte de Ventas</h1>

<div class="contenedor">
<table class="table table-sm">
		<thead>
			<tr>
<th>Cédula</th>
<th>Nombre</th>
<th>Valor total ventas</th>
</tr>
		</thead>
		<tbody id="myTablerep">
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
	<script src="/js/listarreporte.js"></script>
</html>