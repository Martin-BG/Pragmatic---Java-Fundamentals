package edu.homework06.users;

import java.util.Date;

public interface User {

	public boolean login(String password);

	public boolean logout();

	public String getName();

	public Date getRegisrationDate();

	public boolean changePassword(String oldPassword, String newPassword);
}
