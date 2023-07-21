package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LibrosModel;
import services.LibrosService;

@WebServlet (name = "LibrosSv", urlPatterns = "/LibrosSv")
public class LibrosSv extends HttpServlet {

	LibrosService librosService;
	
    public LibrosSv() {
        super();
        librosService = new LibrosService();
    }  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");		
		if (action == null) {
			List <LibrosModel> librosList =  librosService.mostarLibro();
			
			HttpSession miSesion = request.getSession();
			miSesion.setAttribute("listarLibro", librosList);
			response.sendRedirect("mostarLibro.jsp");
		}
		else if (action.equals("actualizar")) {
			Integer id = Integer.parseInt(request.getParameter("id_libro"));			
			LibrosModel librosModel = librosService.obtenerLibro(id);
			HttpSession miSesion = request.getSession();
			miSesion.setAttribute("libros", librosModel);
			
			response.sendRedirect("editarLibro.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");
	if (action.equals("eliminar")) {
		Integer id = Integer.parseInt(request.getParameter("id_libro"));
		librosService.borrarLibro(id);
		response.sendRedirect("Index.jsp");
	}
	else if (action.equals("crear")) {
		LibrosModel librosModel = new LibrosModel ();
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
	    String anio = request.getParameter("anio");
		String ejemplares = request.getParameter("ejemplares");
		String alta = request.getParameter("alta");
		
		librosService.crearLibro(isbn, anio, titulo, ejemplares, alta);
		response.sendRedirect("Index.jsp");
	}
	else if (action.equals("actualizar")) {
		Integer id = Integer.parseInt(request.getParameter("id_libro"));
		LibrosModel librosModel = (LibrosModel) request.getSession().getAttribute("libros");

		librosModel.setIsbn(Long.valueOf(request.getParameter("isbn")));
		librosModel.setTitulo(request.getParameter("titulo"));
		librosModel.setAnio(Integer.valueOf(request.getParameter("anio")));
		librosModel.setEjemplares(Integer.valueOf(request.getParameter("ejemplares")));
		librosModel.setAlta(Integer.valueOf(request.getParameter("alta")));
		
		librosService.editarLibro(librosModel);
		response.sendRedirect("Index.jsp");
	}
	}
}
