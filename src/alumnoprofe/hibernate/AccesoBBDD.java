package alumnoprofe.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;

public class AccesoBBDD {

	static StandardServiceRegistry s = null;
	static SessionFactory sf = null;
	static Session sesion = null;

	public static void inicializarConexion() {
		if (sesion == null) {
			s = new StandardServiceRegistryBuilder().configure("HibernatePA.xml").build();
			sf = new MetadataSources(s).buildMetadata().buildSessionFactory();
			sesion = sf.openSession();
		}
	}

	public static void guardarProfesor(Profesor profe) {
		// inicializarConexion();
		Transaction t = sesion.beginTransaction();
		sesion.save(profe);
		t.commit();

	}

	public static void guardarAlumno(Alumno alum) {
		// inicializarConexion();
		Transaction t = sesion.beginTransaction();
		sesion.save(alum);
		t.commit();

	}

	public static List<Alumno> devolverAlumnos() {
		// inicializarConexion();
		Query consulta = sesion.createQuery("FROM Alumno");
		List<Alumno> alumnos = consulta.getResultList();
		return alumnos;
	}

	public static List<Profesor> devolverProfesor() {
		// inicializarConexion();
		Query consulta = sesion.createQuery("FROM Profesor");
		List<Profesor> profesores = consulta.getResultList();
		return profesores;
	}

	public static Profesor buscarProfesorPorNombre(String nombre_buscado) {
		// inicializarConexion();
		Query consulta = sesion.createQuery("FROM Profesor WHERE nombre='" + nombre_buscado + "'");
		Profesor p = (Profesor) consulta.getSingleResult();
		return p;
	}

	public static void emparejarProfeAlumno(int id_profesor, String id_alumno, Profesor pr) {
		// inicializarConexion();
		//Profesor profe = recuperarProfesorPorId(id_profesor);
		String query = "from Alumno where id in (:ids)";
		String[] ids = id_alumno.split(",");
		List<Integer> lista_ids = new ArrayList<Integer>();
		for (String id : ids) {
			lista_ids.add(Integer.valueOf(id));
		}
		Query q = sesion.createQuery(query);
		q.setParameter("ids", lista_ids);
		List<Alumno> lista_alumnos = q.getResultList();
		List<Profesor> lista_profesores = new ArrayList();
		lista_profesores.add(pr);
		Transaction t = sesion.beginTransaction();
		for (Alumno a : lista_alumnos) {
			a.setListaProfesores(lista_profesores);
			//a.getListaProfesores().add((Profesor) lista_profesores);
			sesion.update(a);
		}
		/**
		 * for (Profesor p : lista_profesores) { p.setListaalumnos(lista_alumnos);
		 * 
		 * }
		 **/
		sesion.update(pr);

		t.commit();
	}

	public static Profesor recuperarProfesorPorId(int idprofesor) {
		Query<Profesor> q = sesion.createQuery("FROM Profesor WHERE id=" + idprofesor);
		Profesor profesor = (Profesor) q.getResultList().get(0);
		return profesor;
	}

	public static Alumno recuperarAlumnoPorId(int id) {
		Query<Alumno> q = sesion.createQuery("FROM Alumno WHERE id=" + id);

		return q.getSingleResult();
	}
}
