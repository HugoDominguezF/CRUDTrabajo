package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import clase.Profesor;
import crud.ProfesorDAO;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ProfesorDAO pdao = new ProfesorDAO();

		Profesor prof;

		int respuesta = 0;

		boolean error = false;
		if (pdao.getConexion() != null) {
			do {

				try {
					menu();
					respuesta = sc.nextInt();

					error = false;

				} catch (InputMismatchException e) {

					System.out.println("Introduce un valor valido");
					sc.next();
					error = true;
				}

			} while (error);

			while (respuesta != 0) {

				switch (respuesta) {

				case 1 -> {
					boolean funciona;
					
					prof = datosProf();
					funciona = pdao.crearProfe(prof);
					
					if(funciona) {
						System.out.println("Se ha creado correctamente");
					}else {
						System.out.println("No se ha podido crear");
					}
				}
				case 2 -> {
					ArrayList<Profesor> lista = pdao.mostrarProfe();
					if (lista.size() > 0) {
						System.out.println(lista);
					}
				}
				case 3 -> {

					int id;

					System.out.println("Que profesor quieres buscar (busqueda por id)");
					id = sc.nextInt();

					prof = pdao.buscarProfe(id);

					if (prof != null) {
						System.out.println(prof);
					} else {
						System.out.println("Ese profesor no existe en la base de datos");
					}
				}
				case 4 -> {
					int id;
					String cambiar;
					String cambiado;

					System.out.println("Que profesor quieres actualizar (busqueda por id)");
					id = sc.nextInt();

					prof = pdao.buscarProfe(id);
					if(prof != null) {
					System.out.println("Quieres cambiar la especialidad o el email");
					cambiar = sc.next();

					switch (cambiar.toLowerCase()) {
					case "email" -> {
						System.out.println("¿Cual es el nuevo email?");
					}
					case "especialidad" -> {
						System.out.println("¿Cual es la nueva especialidad?");
					}
					}
					cambiado = sc.next();
				
					pdao.actualizarProfe(cambiar, cambiado, id);
					System.out.println("Actualizado correctamente");
					}else {
						System.out.println("Ese profesor no se encuentra en la base de datos");
					}

				}
				case 5 -> {
					int id;

					System.out.println("Que profesor quieres eliminar (busqueda por id)");
					id = sc.nextInt();
					
					prof = pdao.buscarProfe(id);
					
					if(prof != null) {
						pdao.eliminarProfe(id);
						System.out.println("Se ha eliminado correctamente");
					}else {
						System.out.println("Ese profesor no se encuentra en la base de datos");
					}

				}
				default -> {
					System.out.println("Error, esa respuesta no esta entre las opciones");
				}

				}

				menu();

				do {

					try {

						respuesta = sc.nextInt();

						error = false;

					} catch (InputMismatchException e) {

						System.out.println("Introduce un valor valido");
						sc.next();
						error = true;
					}

				} while (error);
			}
		}

	}

	public static Profesor datosProf() {

		String nombre;
		String apellido;
		String especialidad;
		String email;

		System.out.println("Inserta el nombre del Profesor");
		nombre = sc.next();

		System.out.println("Inserta el apellido del Profesor");
		apellido = sc.next();

		System.out.println("Inserta la especialidad del Profesor");
		especialidad = sc.next();

		System.out.println("Inserta el email del Profesor");
		email = sc.next();

		Profesor prof = new Profesor(nombre, apellido, especialidad, email);

		return prof;

	}

	public static void menu() {

		System.out.println("Elige una opcion: \n");
		System.out.println("1) Crear Profesor");
		System.out.println("2) Mostrar Profesores");
		System.out.println("3) Buscar Profesor");
		System.out.println("4) Modificar Profesor");
		System.out.println("5) Eliminar Profesor");
		System.out.println("0) Salir");

	}

}
