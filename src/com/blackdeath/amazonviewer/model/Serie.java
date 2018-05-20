package com.blackdeath.amazonviewer.model;

public class Serie {

	private int id;
	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean viewed;
	private int timeViewed;

	private int sessionQuantity;
	// chapters[]

	public Serie(String title, String genre, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

}
