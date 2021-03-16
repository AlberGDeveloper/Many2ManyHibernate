package alumnoprofe.hibernate;

import java.util.List;

public class ClasePrincipal {

//Material de apoyo: HBMClienteProducto
	
	public static void main(String[] args) {
		int opcion = EntradaSalida.mostrarMenu();
		AccesoBBDD.inicializarConexion();

		while (opcion != EntradaSalida.SALIR) {
			switch (opcion) {
			case 1:
				Profesor profe = EntradaSalida.pedirProfesor();
				AccesoBBDD.guardarProfesor(profe);
				break;
			case 2:
				Alumno alum = EntradaSalida.pedirAlumno();
				AccesoBBDD.guardarAlumno(alum);
				break;
			case 3:
				List<Profesor> listaprofesores = AccesoBBDD.devolverProfesor();
				int id_profesor = EntradaSalida.mostrarProfesores(listaprofesores);
				List<Alumno> listaalumnos = AccesoBBDD.devolverAlumnos();
				Profesor pr = AccesoBBDD.recuperarProfesorPorId(id_profesor);
				String id_alumno = EntradaSalida.mostrarAlumnos(listaalumnos);
				pr.setListaalumnos(listaalumnos);
				AccesoBBDD.emparejarProfeAlumno(id_profesor, id_alumno, pr);
				break;
			case 4:
				List<Profesor> listaprof = AccesoBBDD.devolverProfesor();
				EntradaSalida.mostrarProfesores(listaprof);
				break;
			case 5:

				String nombre_buscado = EntradaSalida.pedirNombreBuscado();
				Profesor profe_buscado = AccesoBBDD.buscarProfesorPorNombre(nombre_buscado);
				EntradaSalida.mostrarProfeNombre(profe_buscado);
				break;

			}
			opcion = EntradaSalida.mostrarMenu();

		}

	}
}
