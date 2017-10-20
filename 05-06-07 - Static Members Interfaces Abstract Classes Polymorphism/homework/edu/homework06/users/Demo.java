package edu.homework06.users;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import static edu.homework06.users.Helpers.*;

public class Demo {

	public static void main(String[] args) {
		Map<String, User> users = new LinkedHashMap<>();
		users.put("root", new AdminUserImpl("root", "root", new Date()));

		AdminUser admin = (AdminUser) users.get("root");
		admin.login("root");

		for (int i = 1; i <= 10; i++) {
			User user = new UserImpl("User" + i, "password" + i, new Date());
			admin.addUser(user, users);
		}

		printAllUsers(users);

		User user = (User) users.get("User5");
		user.login("password5");
		System.out.println(user);

		user.changePassword("password5", "new pwd");
		System.out.println(user);

		admin.removeUser(users.get("User3"), users);
		printAllUsers(users);

		user.logout();
		System.out.println(user);
	}

}
