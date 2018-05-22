package com.blackdeath.amazonviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.blackdeath.amazonviewer.model.Movie;

public class Main {

	public static void main(String[] args) {
		showMenu();

	}

	public static void showMenu() {
		int exit = 0;
		do {

			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println("");
			System.out.println("Selecciona el número de la opción deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");

			// Leer la respuesta del usuario
			Scanner sc = new Scanner(System.in);
			int response = sc.nextInt();
			// TODO Validar que response sea un número
			switch (response) {
			case 0:
				// salir

				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				break;
			case 6:
				makeReport(new Date());
				break;

			default:
				System.out.println();
				System.out.println("....¡¡¡Selecciona una opción!!!....");
				System.out.println();
				break;
			}

		} while (exit != 0);
	}

	public static void showMovies() {
		int exit = 1;
		ArrayList<Movie> movies = Movie.makeMoviesList();

		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();

			for (int i = 0; i < movies.size(); i++) {
				System.out
						.println((i + 1) + ". " + movies.get(i).getTitle() + " - Viewed: " + movies.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menú");
			System.out.println();

			Scanner sc = new Scanner(System.in);
			int respuesta = sc.nextInt();

			if(0 == respuesta) {
				showMenu();
			}
			
			Movie movieSelected = movies.get(respuesta - 1);
			movieSelected.setViewed(true);
			Date dateI = movieSelected.startToSee(new Date());

			for (int i = 0; i < 1000000; i++) {
				System.out.println("..........");

			}

			movieSelected.stopToSee(dateI, new Date());

			System.out.println();
			System.out.println("Viste: " + movieSelected);
			System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");

		} while (exit != 0);

	}

	public static void showSeries() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
		} while (exit != 0);
	}

	public static void showChapters() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
		} while (exit != 0);
	}

	public static void showBooks() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
		} while (exit != 0);
	}

	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
		} while (exit != 0);
	}

	public static void makeReport() {

	}

	public static void makeReport(Date date) {

	}

}
