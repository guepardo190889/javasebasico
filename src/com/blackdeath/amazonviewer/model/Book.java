package com.blackdeath.amazonviewer.model;

public class Book extends Publication {
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}

	@Override
	public String toString() {
		String bookDetail = "\n :: BOOK ::" + "\n Title: " + getTitle() + "\n Editition Date: " + getEdititionDate()
				+ "\n Editorial: " + getEditorial() + "\n ISBN: " + getIsbn() + "\n Authors: ";

		for (int i = 0; i < getAuthors().length; i++) {
			bookDetail += "\t" + getAuthors()[i];
		}

		return bookDetail;
	}

}
