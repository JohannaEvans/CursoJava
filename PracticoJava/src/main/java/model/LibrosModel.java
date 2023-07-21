package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class LibrosModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private Long isbn;
	private Integer anio;
	private String titulo;
	private Integer ejemplares;
	private Integer alta;
	
	public LibrosModel() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		isbn = isbn;
	}

	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Integer getAlta() {
		return alta;
	}
	public void setAlta(Integer alta) {
		this.alta = alta;
	}

	public LibrosModel(Integer id, Long isbn, String titulo, Integer ejemplares, Integer alta) {
		this.id = id;
		isbn = isbn;
		this.titulo = titulo;
		this.ejemplares = ejemplares;
		this.alta = alta;
	}
	
	@Override
	public String toString() {
		return "LibrosModel [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", ejemplares=" + ejemplares
				+ ", alta=" + alta + "]";
	}
}
