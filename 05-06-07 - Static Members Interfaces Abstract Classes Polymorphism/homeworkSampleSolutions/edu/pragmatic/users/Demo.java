package edu.pragmatic.users;

public class Demo {
	public static void main(String[] args) {
		
		User normalUser = new UserImpl("Neo");
		AdminUser adminUser = new AdminUserImpl("Agent Smith");
		
		adminUser.addUser(normalUser);
		
		System.out.println(normalUser.getName() + " was created at " + normalUser.getCreationDate());
	}
}
