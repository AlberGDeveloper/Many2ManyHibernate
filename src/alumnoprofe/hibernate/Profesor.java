package alumnoprofe.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//ManyToMany

@Entity
public class Profesor {
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	@ManyToMany
	private List<Alumno> listaalumnos;

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

	public List<Alumno> getListaalumnos() {
		return listaalumnos;
	}

	public void setListaalumnos(List<Alumno> listaalumnos) {
		this.listaalumnos = listaalumnos;
	}

	public Profesor(int id, String nombre, List<Alumno> listaalumnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaalumnos = listaalumnos;
	}

	public Profesor() {
		super();
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", listaalumnos=" + listaalumnos + "]";
	}

}
