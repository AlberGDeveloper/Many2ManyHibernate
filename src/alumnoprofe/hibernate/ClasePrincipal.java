package alumnoprofe.hibernate;

import java.util.List;

public class ClasePrincipal {

//Material de apoyo: HBMClienteProducto -> Formaprofestic + aulas virtuales
	
	public static void main(String[] args) {
		int opcion = EntradaSalida.mostrarMenu();

		while (opcion != EntradaSalida.SALIR) {
			switch (opcion) {
			case 1:
				Profesor profe = EntradaSalida.pedirProfesor();
				AccesoBBDD.guardarCliente(profe);
				break;
			case 2:
				Alumno alum = EntradaSalida.pedirAlumno();
				AccesoBBDD.guardarAlumno(alum);
				break;
			case 3:
				List<Profesor> listaprofesores = AccesoBBDD.devolverProfesor();
				String nombreprofe = EntradaSalida.mostrarProfesores(listaprofesores);
				List<Alumno> listaalumnos = AccesoBBDD.devolverAlumnos();
				String nombrealumni = EntradaSalida.mostrarAlumnos(listaalumnos);
				AccesoBBDD.emparejarProfeAlumno(nombreprofe, nombrealumni);
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
