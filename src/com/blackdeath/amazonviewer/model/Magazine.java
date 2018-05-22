package com.blackdeath.amazonviewer.model;

public class Magazine extends Publication {
	private int id;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		String bookDetail = "\n :: MAGAZINE ::" + "\n Title: " + getTitle() + "\n Editition Date: " + getEdititionDate()
				+ "\n Editorial: " + getEditorial() + "\n Authors: ";

		for (int i = 0; i < getAuthors().length; i++) {
			bookDetail += "\t" + getAuthors()[i];
		}

		return bookDetail;
	}

}
