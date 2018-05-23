package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable {
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;

	public Book(String title, String editorial, String[] authors) {
		setTitle(title);
		setEditorial(editorial);
		setAuthors(authors);
	}

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

	public static ArrayList<Book> makeBooksList() {
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book("Scrum. El arte de hacer el doble de trabajo en la mitad de tiempo", "Gandhi",
				new String[] { "Jeff Sutherland" }));
		books.add(new Book("Pequeño cerdo capitalista", "Gandhi", new String[] { "Sofía Macías" }));
		books.add(new Book("Padre rico padre pobre", "Gandhi", new String[] { "Robert T. Kiyosaki" }));

		return books;
	}

}
