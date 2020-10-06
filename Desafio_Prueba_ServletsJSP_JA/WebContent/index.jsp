<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>


<!-- Link Bootstrap -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
	<!-- Link Css -->
<link href="css/style.css" rel="stylesheet">

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
	<div class="card shadow rounded m-5 px-5" id="back">
		<div class="card align-item-center shadow rounded m-5 p-5" id="card1">
			<h1 class=" second text-center">Horoscopo Chino</h1>
			<div class="preview text-center">
				<img class="preview-img" src="img/fondo.png" alt="Preview Image"
					width="200px" height="200px" />
			</div>

			<div class="aling-items-center px-5 mx-5">
				<form action="IniciarSesion" method="post">

					<div class="form-group ">
						<h4 class="second text-center">Usuario</h4>
						<input class="form-control text-center" type="text"
							name="nombreUser" required
							placeholder="Ingrese su nombre de usuario" /> <span
							class="Error"></span>
					</div>

					<div class="form-group">
						<h4 class="second text-center">Password</h4>
						<input class="form-control text-center" type="password"
							name="claveUser" required placeholder="Ingrese su clave" /> <span
							class="Error"></span>
					</div>

					<div class="form-group">
						<input class="btn btn-block" type="submit" value="Ingresar"
							id="boton" />
					</div>
				</form>

				<div class="container text-left">
					<a class="primer" href="crearCuenta.jsp">No tienes cuenta?.
						Crea una aquí</a>
				</div>
			</div>

		</div>
	</div>
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