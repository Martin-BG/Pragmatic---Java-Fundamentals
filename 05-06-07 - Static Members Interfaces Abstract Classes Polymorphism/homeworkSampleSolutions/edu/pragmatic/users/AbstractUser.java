package edu.pragmatic.users;

import java.util.Date;

public abstract class AbstractUser implements User {

	private String name;
	private boolean loggedIn;
	private Date creationDate;
	
	public AbstractUser(String name){
		this.name = name;
		loggedIn = false;
		creationDate = new Date();
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	@Override
	public void login() {
		this.loggedIn = true;
	}
	
	@Override
	public void logout() {
		this.loggedIn = false;
	}
	
	@Override
	public String toString() {
		return "[name="+name+"]";
	}

	@Override
	public Date getCreationDate() {
		return creationDate;
	}
	
}
