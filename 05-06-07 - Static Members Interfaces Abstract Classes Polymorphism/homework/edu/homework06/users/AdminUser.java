package edu.homework06.users;

import java.util.Map;

public interface AdminUser extends User {

	public boolean addUser(User user, Map<String, User> users);

	public boolean removeUser(User user, Map<String, User> users);
}
