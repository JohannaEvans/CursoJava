<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libros</title>
</head>
<body>

	<h1>Agregar Libros</h1>

	<form action="LibrosSv" method="POST">
		<input type="hidden" name="action" value="crear"> <label>Titulo:
			<input type="text" name="titulo">
		</label> <label>Isbn <input type="text" name="isbn"></label> <label>Anio
			<input type="text" name="anio">
		</label> <label>Ejemplares <input type="text" name="ejemplares"></label>
		<label>Alta <input type="text" name="alta"></label>

		<button type="submit">Enviar</button>
	</form>
	<br>
	<br>
	<br>

	<form action="LibrosSv" method="GET">
		<h1>Ver libros</h1>
		<button type="submit">Mostrar Libros</button>
	</form>


</body>
</html>