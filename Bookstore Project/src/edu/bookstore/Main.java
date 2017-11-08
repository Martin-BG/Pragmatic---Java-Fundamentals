package edu.bookstore;

import java.awt.print.Book;
import java.util.HashMap;

import edu.bookstore.model.Bookstore;
import edu.bookstore.model.exceptions.BookstoreException;

public class Main {

	public static void main(String[] args) {
		try {
			Bookstore bookstore = new Bookstore("ABC", new HashMap<String, Book>());
		} catch (BookstoreException e) {
			System.out.println("Bookstore creation failed");
		}

	}

}
