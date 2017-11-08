package edu.bookstore.model.exceptions;

public class BookException extends Exception {

	private static final long serialVersionUID = -4976973891554404222L;
	
	public BookException() {
		super();
	}

	public BookException(String message) {
		super(message);
	}
}