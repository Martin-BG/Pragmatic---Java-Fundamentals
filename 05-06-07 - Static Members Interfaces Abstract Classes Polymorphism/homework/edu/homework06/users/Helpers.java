package edu.homework06.users;

import java.util.Map;

public class Helpers {
	/**
	 * Prints detailed information about registered users
	 * 
	 * @param users
	 */
	public static void printAllUsers(Map<String, User> users) {
		for (User user : users.values()) {
			System.out.println(user);
		}
	}
}
