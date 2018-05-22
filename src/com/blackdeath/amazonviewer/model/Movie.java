package com.blackdeath.amazonviewer.model;

public class Movie extends Film {

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
		return "\n Title: " + getTitle() + "\n Genre: " + getGenre() + "\n Year: " + getYear() + "\n Creator: "
				+ getCreator() + "\n Duration: " + getDuration();
	}

}
