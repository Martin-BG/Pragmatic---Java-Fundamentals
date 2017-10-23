package edu.pragmatic.users;

import java.util.Date;

/**
 * This interface represents a forum user
 */
public interface User {
	
	/**
	 * @return returns this user's name
	 */
	String getName();
	
	boolean isLoggedIn();
	
	void login();
	
	void logout();
	
	Date getCreationDate();
	
}
