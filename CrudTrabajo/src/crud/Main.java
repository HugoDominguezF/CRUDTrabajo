package crud;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int respuesta = 0;
		boolean error = false;

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

			}
			case 2 -> {

			}
			case 3 -> {

			}
			case 4 -> {

			}
			case 5 -> {

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
