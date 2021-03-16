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
		Alumno gafas = new Alumno();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del alumno: ");
		String nombre = sc.nextLine();
		gafas.setNombre(nombre);
		return gafas;
	}


	public static int mostrarProfesores(List<Profesor> profesores) {
		//System.out.println(profesores);
		for(Profesor p: profesores)
		{
			System.out.println(p.getId()+"-"+p.getNombre());
		}
		System.out.println("Escriba el ID");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		return id;

	}

//Método susceptible a eliminar. No pide mostrar ALUMNOS
	public static String mostrarAlumnos(List<Alumno> listaalumnos) {
		for(Alumno a: listaalumnos)
		{
			System.out.println(a.getId()+"-"+a.getNombre());
		}
		System.out.println("Escriba el nombre del alumno");
		Scanner sc=new Scanner(System.in);
		String nombrealumno=sc.nextLine();
		return nombrealumno;
	}


	public static String pedirNombreBuscado() {
		System.out.println("Introduzca el nombre del profesor a buscar");
		Scanner sc=new Scanner(System.in);
		String nombre=sc.nextLine();
		return nombre;
	}


	public static void mostrarProfeNombre(Profesor profe_buscado) {
		System.out.println("NOMBRE: "+profe_buscado.getNombre());
		System.out.println("ID: "+profe_buscado.getId());
		List<Alumno> lista_alumnos=profe_buscado.getListaalumnos();
		for(Alumno a: lista_alumnos)
		{
			System.out.println("ID: "+a.getId());
			System.out.println("NOMBRE ALUMNO: "+a.getNombre());

		}
		
	}
		
	}

