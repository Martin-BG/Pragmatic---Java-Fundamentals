package edu.homework06.users;

import java.util.Date;
import java.util.Map;

public class AdminUserImpl extends AbstractUser implements AdminUser {

	public AdminUserImpl(String name, String password, Date registrationDate) {
		super(name, password, registrationDate);
	}

	@Override
	public boolean addUser(User user, Map<String, User> users) {
		if (!isLoggedIn() || users.containsKey(user.getName())) {
			return false;
		}
		users.put(user.getName(), user);
		System.out.printf("Added user %s%n", user.getName());
		return true;
	}

	@Override
	public boolean removeUser(User user, Map<String, User> users) {
		if (!isLoggedIn() || !users.containsKey(user.getName())) {
			return false;
		}
		users.remove(user.getName());
		System.out.printf("Removed user %s%n", user.getName());
		return true;
	}

	@Override
	public String toString() {
		return String.format("Admin %s", super.toString());
	}

}
