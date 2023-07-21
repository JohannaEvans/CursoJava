package services;

import repository.LibrosDao;
import java.util.List;
import model.LibrosModel;

public class LibrosService {
LibrosDao librosDao;

public LibrosService() {
	super();
	librosDao = new LibrosDao();
}

public void crearLibro(String isbn, String anio, String titulo, String ejemplares, String alta ) {
	LibrosModel librosModel = new LibrosModel();

	Long castIsbn = Long.valueOf(isbn);
	Integer castAnio = Integer.valueOf(anio);
	Integer castEjemplares = Integer.valueOf(ejemplares);
	Integer castAlta = Integer.valueOf(alta);

	librosModel.setIsbn(castIsbn);
	librosModel.setTitulo(titulo);
	librosModel.setAnio(castAnio);
	librosModel.setEjemplares(castEjemplares);
	librosModel.setAlta(castAlta);
	
	librosDao.GuardarLibro(librosModel);
}

public List<LibrosModel> mostarLibro () {
	List<LibrosModel> librosList = librosDao.obtenerLibros();
	return librosList;
}

public void borrarLibro(Integer id) {
	librosDao.eliminarLibro(id);
}

public void editarLibro (LibrosModel librosModel) {
	librosDao.actualizarLibro(librosModel);
}

public LibrosModel obtenerLibro (Integer id) {
	LibrosModel librosModel = librosDao.buscarLibroPorId(id);
	return librosModel;
}
}
