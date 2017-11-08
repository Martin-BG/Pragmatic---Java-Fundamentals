package edu.bookstore.model;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

import edu.bookstore.model.exceptions.BookstoreException;

public class Bookstore {
	
	private String name;
	private Map<String, Book> books;
	
	public Bookstore(String name, Map<String,Book> books) throws BookstoreException {
		super();
		this.setName(name);
		this.setBooks(books);
	}
	
	private void setName(String name) throws BookstoreException {
		if (name == null || name.trim().isEmpty()) {
			throw new BookstoreException();
		}
		this.name = name.trim();
	}
	
	private void setBooks(Map<String, Book> books) throws BookstoreException {
		if (books == null) {
			throw new BookstoreException();
		}
		this.books = books;
	}
}