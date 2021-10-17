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
<title>Ventas</title>
</head>

<body>
	<jsp:include page="/menu/menu.jsp"></jsp:include>
	<h1>Ventas</h1>
	
		
	<div class="mx-auto" style="width: 1000px;">
		<form id="form" class="row g-3 needs-validation">
		
			<div style="display: flex; align-items: center;" class="col-md-4 position-relative" >
				<label class="form-label">Cedula</label> <input type="text"
					class="form-control" id="inputCedula" name="cedula_usuario"
					aria-describedby="inputGroupPrepend">
					<button type="button" onclick="buscar()" class="btn btn-success">Consultar</button>
			</div>
			<div style="display: flex; align-items: center;" class="col-md-4 position-relative" >
				
				<label class="form-label">Cliente</label> <input type="text"
					class="form-control" id="labelUsuario" name="nombre_usuario"
					aria-describedby="inputGroupPrepend">
			</div>
			<div style="display: flex; align-items: center;" class="col-md-2 position-relative" >
				<label class="form-label">Consec.</label> <input type="text"
					class="form-control" id="labelConsec" name="numero_consec"
					aria-describedby="inputGroupPrepend">
			</div>
		
		
			<div  class="col-md-3 position-relative" >
				<label class="form-label">Cod. producto</label> 
			<div style="display: flex; align-items: center;" >	
				<input type="text"
					class="form-control" id="inputCodigo" name="codigo_producto"
					aria-describedby="inputGroupPrepend">
						
				<button type="button" onclick="buscarProducto(1)" class="btn btn-success" >Consultar</button>
			</div>	
			</div>
			<div  class="col-md-3 position-relative" >
				<label class="form-label">Nombre Producto</label> <input type="text"
					class="form-control" id="labelNombre" name="nombre_producto"
					aria-describedby="inputGroupPrepend">
			</div>
			<div  class="col-md-2 position-relative" >
				<label class="form-label">Cant.</label> <input type="text"
					class="form-control" id="labelCantidad1" name="cantidad_uno"
					aria-describedby="inputGroupPrepend">
			</div>
			<div  class="col-md-3 position-relative" >
				<label class="form-label">Valor Total</label> <input type="text"
					class="form-control" id="labelTotal1" name="total_uno"
					aria-describedby="inputGroupPrepend">
			</div>
		
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative">
				 <input type="text"
					class="form-control" id="inputCodigoDos" name="codigo_producto"
					aria-describedby="inputGroupPrepend">
				<button type="button" onclick="buscarProducto(2)" class="btn btn-success">Consultar</button>
			</div>	
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative">	
				 <input type="text"
					class="form-control" id="labelNombreDos" name="nombre_producto2"
					aria-describedby="inputGroupPrepend">
			</div>	
				<div style="display: flex; align-items: center;" class="col-md-2 position-relative">
				 <input type="text"
					class="form-control" id="labelCantidad2" name="cantidad_dos"
					aria-describedby="inputGroupPrepend">
				</div>
				
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative">	
				<input type="text"
					class="form-control" id="labelTotal2" name="total_dos"
					aria-describedby="inputGroupPrepend">
			
			</div>
			
			
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative">
				 <input type="text"
					class="form-control" id="inputCodigoTres" name="codigo_producto"
					aria-describedby="inputGroupPrepend">
				<button type="button" onclick="buscarProducto(3)" class="btn btn-success">Consultar</button>
			</div>	
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative">	
				 <input type="text"
					class="form-control" id="labelNombreTres" name="nombre_producto3"
					aria-describedby="inputGroupPrepend">
			</div>	
			<div style="display: flex; align-items: center;" class="col-md-2 position-relative">
				 <input type="text"
					class="form-control" id="labelCantidad3" name="cantidad_tres"
					aria-describedby="inputGroupPrepend">
			</div>
				
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative">	
				<input type="text"
					class="form-control" id="labelTotal3" name="total_tres"
					aria-describedby="inputGroupPrepend">
			</div>
			<div>						
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative">
				<label class="form-label">Total Venta</label> <input type="text"
					class="form-control" id="labelTotalV" name="total_venta"
					aria-describedby="inputGroupPrepend">
			</div>
			</div>			
			<div>			
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative";>
				<label class="form-label">Total IVA</label> <input type="text"
					class="form-control" id="labelTotalIva" name="total_iva"
					aria-describedby="inputGroupPrepend">			
			</div>
			</div>	
			
			<div style="display: flex; align-items: center;" class="col-md-3 position-relative">	
				<label class="form-label">Total con IVA</label> <input type="text" 
					class="form-control" id="labelTotalconIva" name="total_coniva"
					aria-describedby="inputGroupPrepend">
			</div>			
			<div>
			<button type="button" onclick="buscarProducto()" class="btn btn-success">confirmar</button>
			</div>
			
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="/js/venta/venta.js"></script>
</body>
</html>