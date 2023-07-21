<%@ page import="model.LibrosModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Libro</title>
</head>
<body>
	<h1>Editar Libro</h1>
	<% LibrosModel librosModel = (LibrosModel) request.getSession().getAttribute("libros"); %>

	<form action="LibrosSv" method="POST">

		<input type="hidden" name="action" value="actualizar"> <input
			type="hidden" name="id_libro" value=<%= lib.getId() %>> <label>Titulo:<input
			type="text" name="titulo" value=<%= lib.getTitulo()%>>
		</label> <label>Isbn:<input type="text" name="isbn"
			value=<%= lib.getIsbn() %>>
		</label> <label>Anio:<input type="text" name="anio"
			value=<%= lib.getAnio() %>>
		</label> <label>Ejemplares:<input type="text" name="ejemplares"
			value=<%= lib.getEjemplares() %>>
		</label> <label>Alta:<input type="text" name="alta"
			value=<%= lib.getAlta() %>>
		</label>
		<button type="submit">Guardar</button>

	</form>

</body>
</html>