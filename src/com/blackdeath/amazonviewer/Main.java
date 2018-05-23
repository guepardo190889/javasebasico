package com.blackdeath.amazonviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.blackdeath.amazonviewer.model.Book;
import com.blackdeath.amazonviewer.model.Chapter;
import com.blackdeath.amazonviewer.model.Movie;
import com.blackdeath.amazonviewer.model.Serie;

public class Main {

	public static void main(String[] args) {
		showMenu();

	}

	public static void showMenu() {
		int exit = 0;
		do {

			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println("");
			System.out.println("Selecciona el n�mero de la opci�n deseada");
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
			// TODO Validar que response sea un n�mero
			switch (response) {
			case 0:
				// salir
				exit = 0;
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
				System.out.println("....���Selecciona una opci�n!!!....");
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

			System.out.println("0. Regresar al Men�");
			System.out.println();

			Scanner sc = new Scanner(System.in);
			int respuesta = sc.nextInt();

			if (0 == respuesta) {
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
		int exit = 1;
		ArrayList<Serie> series = Serie.makeSeriesList();

		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();

			for (int i = 0; i < series.size(); i++) {
				System.out
						.println((i + 1) + ". " + series.get(i).getTitle() + " - Viewed: " + series.get(i).isViewed());
			}

			System.out.println("0. Regresar al Men�");
			System.out.println();

			Scanner sc = new Scanner(System.in);
			int respuesta = sc.nextInt();

			if (0 == respuesta) {
				showMenu();
			}

			Serie serieSelected = series.get(respuesta - 1);

			showChapters(serieSelected.getChapters());
		} while (exit != 0);
	}

	public static void showChapters(ArrayList<Chapter> chapters) {
		int exit = 1;
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();

			for (int i = 0; i < chapters.size(); i++) {
				System.out.println(
						(i + 1) + ". " + chapters.get(i).getTitle() + " - Viewed: " + chapters.get(i).isViewed());
			}

			System.out.println("0. Regresar al Men�");
			System.out.println();

			Scanner sc = new Scanner(System.in);
			int respuesta = sc.nextInt();

			if (0 == respuesta) {
				showSeries();
			}

			Chapter chapterSelected = chapters.get(respuesta - 1);
			chapterSelected.setViewed(true);
			Date dateI = chapterSelected.startToSee(new Date());

			for (int i = 0; i < 1000000; i++) {
				System.out.println("..........");
			}

			chapterSelected.stopToSee(dateI, new Date());

			System.out.println();
			System.out.println("Viste: " + chapterSelected);
			System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
		} while (exit != 0);
	}

	public static void showBooks() {
		int exit = 1;
		ArrayList<Book> books = Book.makeBooksList();

		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();

			for (int i = 0; i < books.size(); i++) {
				System.out.println((i + 1) + ". " + books.get(i).getTitle() + " - Readed: " + books.get(i).isReaded());
			}

			System.out.println("0. Regresar al Men�");
			System.out.println();

			Scanner sc = new Scanner(System.in);
			int respuesta = sc.nextInt();

			if (0 == respuesta) {
				showMenu();
			}

			Book bookSelected = books.get(respuesta - 1);
			bookSelected.setReaded(true);
			Date dateI = bookSelected.startToSee(new Date());

			for (int i = 0; i < 1000000; i++) {
				System.out.println("..........");
			}

			bookSelected.stopToSee(dateI, new Date());

			System.out.println();
			System.out.println("Le�ste: " + bookSelected);
			System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos");

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

	public static int leeRespuesta(String repuesta) {
		int respuesta = -1;

		Scanner sc = new Scanner(System.in);

		String respuestaStr = sc.nextLine();

		if (isRespuestaValida(respuestaStr)) {
			respuesta = Integer.parseInt(respuestaStr);
		}

		return respuesta;
	}

	private static boolean isRespuestaValida(String respuesta) {
		return "0".equals(respuesta) || "1".equals(respuesta) || "2".equals(respuesta) || "3".equals(respuesta)
				|| "4".equals(respuesta) || "5".equals(respuesta) || "6".equals(respuesta);
	}

}
