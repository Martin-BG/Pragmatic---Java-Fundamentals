package edu.pragmatic.users;

public class AdminUserImpl extends AbstractUser implements AdminUser {

	public AdminUserImpl(String name) {
		super(name);
	}

	@Override
	public boolean addUser(User user) {
		System.out.println("Add user: " + user);
		return true;
	}

	@Override
	public boolean removeUser(User user) {
		System.out.println("Remove user: " + user);
		return true;
	}

}
