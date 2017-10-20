package edu.homework06.users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractUser implements User {

	private String name;
	private String password;
	private Date registrationDate;
	private boolean isLoggedIn;

	/**
	 * @param name
	 * @param password
	 * @param registrationDate
	 */
	public AbstractUser(String name, String password, Date registrationDate) {
		super();
		this.name = name;
		this.password = password;
		this.registrationDate = registrationDate;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	@Override
	public boolean login(String password) {
		if (isLoggedIn || password == null || !this.password.equals(password)) {
			return false;
		}
		isLoggedIn = true;
		return true;
	}

	@Override
	public boolean logout() {
		if (!isLoggedIn) {
			return false;
		}
		isLoggedIn = false;
		return true;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getRegisrationDate() {
		return registrationDate;
	}

	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		if (oldPassword == null || !password.equals(oldPassword) || newPassword == null
				|| password.equals(newPassword)) {
			return false;
		}
		password = newPassword;
		return true;
	}

	@Override
	public String toString() {
		final DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		dateFormat.format(registrationDate);
		return String.format("[name=%10s | pwd=%10s | Date=%s | Logged=%6s]", name, password,
				dateFormat.format(registrationDate), isLoggedIn);
	}
}
