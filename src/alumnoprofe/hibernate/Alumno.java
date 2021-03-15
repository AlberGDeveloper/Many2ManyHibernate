package alumnoprofe.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Alumno {
	@Id
	@GeneratedValue
	private int id;

	private String nombre;

	@ManyToMany
	private List<Profesor> listaProfesores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	public Alumno(int id, String nombre, List<Profesor> listaProfesores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaProfesores = listaProfesores;
	}

	public Alumno() {
		super();
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", listaProfesores=" + listaProfesores + "]";
	}
	
	

}
