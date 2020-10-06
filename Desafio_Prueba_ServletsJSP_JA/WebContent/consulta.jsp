<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta</title>
<!-- Link Css -->
<link href="css/style.css" rel="stylesheet">
<!-- Link Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Palanquin:wght@300;600&display=swap"
	rel="stylesheet">

<link
	href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap"
	rel="stylesheet">

<!-- Fonts Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body class="fondo">
	<%
		List<String> resultado = (List<String>) request.getAttribute("listaAños");
	%>
	<div class="card shadow rounded m-5 px-5" id="back">
		<nav>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a
					class="nav-link active second text-dark" href="buscarUsuario.jsp">
						<h4>Buscar usuarios</h4>
				</a></li>
				<li class="nav-item"><a
					class="nav-link active second text-dark" href="listarUsuarios.jsp">
						<h4>Listar usuarios</h4>
				</a></li>
				<li class="nav-item"><a
					class="nav-link active second text-dark"
					href="preModificarUsuarios.jsp">
						<h4>Modificar usuarios</h4>
				</a></li>
				<li class="nav-item"><a
					class="nav-link active second text-dark" href="preBorrar.jsp">
						<h4>Borrar usuarios</h4>
				</a></li>
				<li class="nav-item"><a
					class="nav-link active second text-dark" href="cerrarSesion.jsp">
						<h4>Cerrar Sesion</h4>
				</a></li>
			</ul>
		</nav>
		<div class="card align-item-center shadow rounded m-5 p-5" id="card1">
			<h1 class=" second text-center">Horoscopo Chino</h1>
			<div class="preview text-center">
				<img class="preview-img" src="img/fondo.png" alt="Preview Image"
					width="200px" height="200px" />
				<h1 class=" second text-center">Consulta tu signo</h1>
			</div>

			<div class="aling-items-center px-5 mx-5">
				<form action="ConsultaSigno" method="post">
				
						<div class="form-group">
							<h4 class="primer text-center">Elija un año para consultar</h4>

							<select class="form-control" id="exampleFormControlSelect1"
								name="añoSigno">
								<% for (String año : resultado) { %>
								<option value="<%=año%>">
									<%=año%>
								</option>
								<%
									}
								%>
							</select><br>
						</div>

					<div class="form-group">
						<input class="btn btn-block" type="submit" value="Buscar"
							id="boton" />
					</div>

				</form>
			</div>

		</div>
	</div>


	<!-- jQuery, Popper.js,Bootstrap JS -->

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

</body>
</html>