package edu.bookstore.model;

import edu.bookstore.model.exceptions.BookException;

public class Book {
	
	private String title;
	private String author;
	private double price;
	private String publisher;
	private boolean isForeign;
	
	public Book(String title, String author, double price, String publisher, boolean isForeign) throws BookException {
		super();
		this.setTitle(title);
		this.setAuthor(author);
		this.setPrice(price);
		this.setPublisher(publisher);
		this.setForeign(isForeign);
	}
	
	private void setTitle(String title) throws BookException {
		if (title == null || title.trim().isEmpty()) {
			throw new BookException();
		}
		this.title = title.trim();
	}
	
	private void setAuthor(String author) throws BookException {
		if (author == null || author.trim().isEmpty()) {
			throw new BookException();
		}
		this.author = author.trim();
	}
	
	private void setPrice(double price) throws BookException {
		if (price <= 0d) {
			throw new BookException();
		}
		this.price = price;
	}
	
	private void setPublisher(String publisher) throws BookException {
		if (publisher == null || publisher.trim().isEmpty()) {
			throw new BookException();
		}
		this.publisher = publisher.trim();
	}
	
	private void setForeign(boolean isForeign) {
		this.isForeign = isForeign;
	}
}
