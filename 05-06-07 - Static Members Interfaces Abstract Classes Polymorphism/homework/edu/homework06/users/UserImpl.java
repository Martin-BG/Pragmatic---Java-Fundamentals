package edu.homework06.users;

import java.util.Date;

public class UserImpl extends AbstractUser {

	public UserImpl(String name, String password, Date registrationDate) {
		super(name, password, registrationDate);
	}

	@Override
	public String toString() {
		return String.format("User  %s", super.toString());
	}

}
