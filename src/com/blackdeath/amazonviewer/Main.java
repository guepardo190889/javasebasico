package com.blackdeath.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.blackdeath.amazonviewer.model.Book;
import com.blackdeath.amazonviewer.model.Chapter;
import com.blackdeath.amazonviewer.model.Movie;
import com.blackdeath.amazonviewer.model.Serie;
import com.blackdeath.amazonviewer.util.AmazonUtil;
import com.blackdeath.makereport.Report;

public class Main {

	private static ArrayList<Movie> movies = Movie.makeMoviesList();
	private static ArrayList<Serie> series = Serie.makeSeriesList();
	private static ArrayList<Book> books = Book.makeBooksList();

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
			int response = AmazonUtil.leeRespuesta();

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
				System.out.println("....¡¡¡Selecciona una opción!!!....");
				System.out.println();
				break;
			}

		} while (exit != 0);
	}

	public static void showMovies() {
		int exit = 1;

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

			int respuesta = AmazonUtil.leeRespuesta();

			if (0 == respuesta) {
				showMenu();
			} else if (respuesta > 0) {
				Movie movieSelected = movies.get(respuesta - 1);
				movieSelected.setViewed(true);

				Date dateI = movieSelected.startToSee(new Date());
				movieSelected.play();
				movieSelected.stopToSee(dateI, new Date());

				System.out.println();
				System.out.println("Viste: " + movieSelected);
				System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");
			}
		} while (exit != 0);
	}

	public static void showSeries() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();

			for (int i = 0; i < series.size(); i++) {
				System.out
						.println((i + 1) + ". " + series.get(i).getTitle() + " - Viewed: " + series.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menú");
			System.out.println();

			int respuesta = AmazonUtil.leeRespuesta();

			if (0 == respuesta) {
				showMenu();
			} else if (respuesta > 0) {
				Serie serieSelected = series.get(respuesta - 1);

				showChapters(serieSelected.getChapters());
			}
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

			System.out.println("0. Regresar al Menú");
			System.out.println();

			int respuesta = AmazonUtil.leeRespuesta();

			if (0 == respuesta) {
				showSeries();
			} else if (respuesta > 0) {
				Chapter chapterSelected = chapters.get(respuesta - 1);
				chapterSelected.setViewed(true);
				Date dateI = chapterSelected.startToSee(new Date());
				chapterSelected.play();
				chapterSelected.stopToSee(dateI, new Date());

				System.out.println();
				System.out.println("Viste: " + chapterSelected);
				System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
			}
		} while (exit != 0);
	}

	public static void showBooks() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();

			for (int i = 0; i < books.size(); i++) {
				System.out.println((i + 1) + ". " + books.get(i).getTitle() + " - Readed: " + books.get(i).isReaded());
			}

			System.out.println("0. Regresar al Menú");
			System.out.println();

			int respuesta = AmazonUtil.leeRespuesta();

			if (0 == respuesta) {
				showMenu();
			} else if (respuesta > 0) {
				Book bookSelected = books.get(respuesta - 1);
				bookSelected.setReaded(true);
				Date dateI = bookSelected.startToSee(new Date());
				bookSelected.read();
				bookSelected.stopToSee(dateI, new Date());

				System.out.println();
				System.out.println("Le�ste: " + bookSelected);
				System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos");
			}
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
		Report report = new Report();
		report.setNameFile("reporte");
		report.setTitle(":: VISTOS ::");
		report.setExtension("txt");

		String content = "";

		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				content += movie.toString() + "\n";
			}
		}

		report.setContent(content);

		report.makeReport();
	}

	public static void makeReport(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Report report = new Report();
		report.setNameFile("reporte" + sdf.format(date));
		report.setTitle(":: VISTOS ::");
		report.setExtension("txt");

		String content = "";

		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				content += movie.toString() + "\n";
			}
		}

		report.setContent(content);

		report.makeReport();
	}

}
