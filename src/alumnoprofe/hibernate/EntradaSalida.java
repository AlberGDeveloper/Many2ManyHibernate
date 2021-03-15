package alumnoprofe.hibernate;

import java.util.List;
import java.util.Scanner;

public class EntradaSalida {
	
	public static final int INSERTAR_PROFESOR = 1;
	public static final int INSERTAR_ALUMNO = 2;
	public static final int ASOCIAR_PROFESOR_ALUMNO = 3;
	public static final int LISTAR_PROFESORES = 4;
	public static final int BUSCAR_PROFESOR = 5;
	public static final int SALIR = 6;


	public static int mostrarMenu() {
		System.out.println(INSERTAR_PROFESOR + " Insertar profesor");
		System.out.println(INSERTAR_ALUMNO + " Insertar alumno");
		System.out.println(ASOCIAR_PROFESOR_ALUMNO + " Asociar profesor-alumno");
		System.out.println(LISTAR_PROFESORES + " Listar profesores");
		System.out.println(BUSCAR_PROFESOR + " Buscar profesor por nombre");
		System.out.println(SALIR + " Salir");
		Scanner sc=new Scanner(System.in);
		int opcion=sc.nextInt();
		return opcion;
	}


	public static Profesor pedirProfesor() {
		Profesor profe = new Profesor();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del profesor: ");
		String nombre = sc.nextLine();
		profe.setNombre(nombre);
		return profe;
	}


	public static Alumno pedirAlumno() {
		// TODO Auto-generated method stub
		return null;
	}


	public static int mostrarProfesores(List<Profesor> clientes) {
		// TODO Auto-generated method stub
		return 0;
	}


	public static String mostrarAlumnos(List<Alumno> listaalumnos) {
		// TODO Auto-generated method stub
		return null;
	}


	public static String pedirNombreBuscado() {
		// TODO Auto-generated method stub
		return null;
	}


	public static void mostrarProfeNombre(Profesor profe_buscado) {
		// TODO Auto-generated method stub
		
	}

}
