package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable {

	private int id;
	private int timeViewed;

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	public int getId() {
		return id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	@Override
	public String toString() {
		return "\n :: MOVIE ::" + "\n Title: " + getTitle() + "\n Genre: " + getGenre() + "\n Year: " + getYear()
				+ "\n Creator: " + getCreator() + "\n Duration: " + getDuration();
	}

	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int) (dateF.getTime() - dateI.getTime()));
		} else {
			setTimeViewed(0);
		}
	}

	public static ArrayList<Movie> makeMoviesList() {
		ArrayList<Movie> movies = new ArrayList<>();
		movies.add(new Movie("El juego de Ender", "Ciencia Ficci�n", "Gavin Hood", 114, (short) 2013));
		movies.add(new Movie("Titanes del Pac�fico", "Ciencia Ficci�n", "Guillermo del Toro", 132, (short) 2013));
		movies.add(new Movie("Interestelar ", "Ciencia Ficci�n", "Christopher Nolan", 169, (short) 2014));
		movies.add(new Movie("Contacto", "Ciencia Ficci�n", "Robert Zemeckis", 149, (short) 1997));
		movies.add(new Movie("Coherence", "Ciencia Ficci�n, Suspenso", "James Ward Byrkit", 89, (short) 2013));
		movies.add(new Movie("El Origen", "Drama, Suspenso, Acci�n", "Christopher Nolan", 148, (short) 2010));
		movies.add(new Movie("Wall-E", "Ciencia Ficci�n", "Andrew Stanton", 98, (short) 2008));
		movies.add(new Movie("Matrix", "Ciencia Ficci�n", "Hermanos Wachowski", 136, (short) 1999));
		movies.add(new Movie("Avatar", "Ciencia Ficci�n", "James Cameron", 162, (short) 2009));
		movies.add(new Movie("A.I. Inteligencia Artificial", "Ciencia Ficci�n", "Steven Spielberg", 146, (short) 2001));
		movies.add(new Movie("Prometheus", "Ciencia Ficci�n", "Ridley Scott", 124, (short) 2012));
		movies.add(new Movie("Minority Report", "Ciencia Ficci�n", "Steven Spielberg", 145, (short) 2002));
		movies.add(new Movie("El quinto elemento", "Ciencia Ficci�n", "Luc Besson", 127, (short) 1997));
		movies.add(new Movie("Yo, robot ", "Ciencia Ficci�n", "Alex Proyas", 115, (short) 2004));

		return movies;
	}

}
