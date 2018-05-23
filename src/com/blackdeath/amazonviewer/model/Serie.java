package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {

	private int id;
	private int sessionQuantity;
	private ArrayList<Chapter> chapters;

	public Serie(String title, String genre, String creator, int duration, int sessionQuantity,
			ArrayList<Chapter> chapters) {
		super(title, genre, creator, duration);
		this.sessionQuantity = sessionQuantity;
		this.chapters = chapters;
	}

	public int getId() {
		return id;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "\n :: SERIE ::" + "\n Title: " + getTitle() + "\n Genre: " + getGenre() + "\n Year: " + getYear()
				+ "\n Creator: " + getCreator() + "\n Duration: " + getDuration() + "\n Session Quantity: "
				+ getSessionQuantity();
	}

	public static ArrayList<Serie> makeSeriesList() {
		ArrayList<Serie> series = new ArrayList<>();

		series.add(new Serie("Lost", "Ciencia Ficci�n", "J.J. Abrams", 43, 6, Chapter.makeLostChapters()));
		series.add(new Serie("Black Mirror", "Ciencia Ficci�n", "Charlie Brooker", 44, 4,
				Chapter.makeBlackMirrorChapters()));

		return series;
	}

}
