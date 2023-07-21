package repository;
import java.util.ArrayList;
import java.util.List;

import model.LibrosModel;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import connections.Conexion;

public class LibrosDao {
	EntityManager entity;
	
	public void GuardarLibro(LibrosModel librosModel){
		entity = Conexion.getEntityManager();
		try{
			entity.getTransaction().begin();
			entity.persist(librosModel);
			entity.getTransaction().commit();
		}
		finally {
			if (entity != null){
				entity.close();
			}
			}
		}	
		
	public void eliminarLibro(Integer id){
		LibrosModel librosModel = buscarLibroPorId(id);
		
		try{
			entity.getTransaction().begin();
			entity.remove(librosModel);
			entity.getTransaction().commit();
		}finally {
			if (entity != null){
				entity.close();
			}
			}
		}
	
	public void actualizarLibro (LibrosModel librosModel ) {
		entity = Conexion.getEntityManager();
		try {
			entity.getTransaction().begin();
			entity.merge(librosModel);
			entity.getTransaction().commit();
		}finally {
			if (entity != null) {
				entity.close(); 
			}
			}
		}		
	
	public LibrosModel buscarLibroPorId (Integer id) {
		entity = Conexion.getEntityManager();
		
		LibrosModel librosModel = new LibrosModel();
		librosModel = entity.find (LibrosModel.class, id);
		return librosModel;		
		
	}
	
	public List <LibrosModel> obtenerLibros(){
		entity = Conexion.getEntityManager();
		try {
			List<LibrosModel> librosModel = new ArrayList();
			Query sql =  entity.createQuery ("SELECT a FROM Libros a");
			return librosModel = sql.getResultList();
		}finally {
			if (entity != null) {
				entity.close();
			}
		}
	}

	public void cerrarConexion() {
		entity.close();
	}

}
