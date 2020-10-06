<%@page import="java.util.List"%>
<%@page import="com.desafiolatam.modelo.RegistroDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Usuario</title>
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
		List<RegistroDTO> resultado = (List<RegistroDTO>) request.getAttribute("user");
	%>

	<div class="card shadow rounded m-5 px-5" id="back">
		<nav>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a
					class="nav-link active second text-dark" href="preConsulta.jsp">
						<h4>Consulta signos</h4>
				</a></li>
				<li class="nav-item"><a
					class="nav-link active second text-dark" href="buscarUsuario.jsp">
						<h4>Buscar usuarios</h4>
				</a></li>
				<li class="nav-item"><a
					class="nav-link active second text-dark" href="listarUsuarios.jsp">
						<h4>Listar usuarios</h4>
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
				<h1 class=" second text-center">Modificar usuario</h1>
			</div>


			<div class="aling-items-center px-5 mx-5">

				<div class="aling-items-center px-5 mx-5">
					<form action="ModificarUsuario" method="post">


						<div class="form-group">
							<h4 class="primer text-center">Elija una cuenta para
								modificar</h4>

							<select class="form-control" id="exampleFormControlSelect1"
								name="nombreUpdate">
								<%
									for (RegistroDTO dato : resultado) {
								%>
								<option value="<%=dato.getUser()%>">
									<%=dato.getUser()%>
								</option>
								<%
									}
								%>
							</select><br>
						</div>

						<div class="form-group">
							<h4 class="primer text-center">Ingrese una nueva clave</h4>
							<input class="form-control text-center" type="text"
								name="claveUpdate" placeholder="Ingrese clave" /> <span
								class="Error"></span>
						</div>

						<div class="form-group">
							<hr>
						</div>

						<div class="form-group">
							<h4 class="primer text-center">Ingrese un nuevo correo
								electrónico</h4>
							<input class="form-control text-center" type="text"
								name="correoUpdate" placeholder="Ingrese correo electrónico" />
							<span class="Error"></span>
						</div>

						<div class="form-group">
							<hr>
						</div>

						<div class="form-group">
							<h4 class="primer text-center">Ingrese una nueva fecha de
								nacimiento</h4>
							<input class="form-control text-center" type="date"
								name="fechaUpdate" placeholder="Formato YYYY-MM-DD" /> <span
								class="Error"></span>
						</div>

						<div class="form-group">
							<hr>
						</div>

						<div class="form-group">
							<input class="btn btn-block" type="submit"
								value="Actualizar registro" id="boton" />
						</div>
					</form>
				</div>

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