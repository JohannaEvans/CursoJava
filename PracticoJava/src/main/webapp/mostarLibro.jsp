<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" import="model.LibrosModel"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Libros</title>
</head>
<body>
	<h1>Mostrar Libros</h1>

	<%
List<LibrosModel> listaLibros = (List)request.getSession().getAttribute("listarLibro");

for (LibrosModel libro : listaLibros ){

%>
	<h3>
		Titulo:
		<%= lib.getTitulo() %>
	</h3>
	<h3>
		Isbn:
		<%= lib.getIsbn() %>
	</h3>
	<h3>
		Anio:
		<%= lib.getAnio() %>
	</h3>
	<h3>
		Ejemplares:
		<%= lib.getEjemplares() %>
	</h3>
	<h3>
		Alta:
		<%= lib.getAlta() %>
	</h3>
	<br>

	<form action="LibrosSv" method="POST">
		<input type="hidden" name="action" value="eliminar"><input
			type="hidden" name="id_libro" value=<%= lib.getId() %>>
		<button type="submit">Eliminar</button>
	</form>

	<form action="LibrosSv" method="GET">
		<input type="hidden" name="action" value="actualizar"><input
			type="hidden" name="id_libro" value=<%= lib.getId() %>>
		<button type="submit">Editar</button>
	</form>

	<% } %>
</body>
</html>