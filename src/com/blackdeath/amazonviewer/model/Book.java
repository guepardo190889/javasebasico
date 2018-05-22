package com.blackdeath.amazonviewer.model;

import java.util.Date;

public class Book extends Publication implements IVisualizable {
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

	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if (dateF.getSeconds() > dateI.getSeconds()) {
			setTimeReaded(dateF.getSeconds() - dateI.getSeconds());
		} else {
			setTimeReaded(0);
		}
	}

}
