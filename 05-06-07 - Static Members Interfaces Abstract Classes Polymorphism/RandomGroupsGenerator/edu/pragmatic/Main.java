package edu.pragmatic;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of the persons: ");
		int personsCount = sc.nextInt();
		
		Person[] persons = new Person[personsCount];
		for(int i = 0; i < personsCount; i++) {
			System.out.println("Enter the number of person " + (i + 1) + ": ");
			String name = sc.next();
			Person person = new Person(name);
			persons[i] = person;
		}
		
		Group[] groups = GroupsGenerator.generateGroups(persons);
		if(groups != null) {
			for(Group group : groups) {
				System.out.println("-----------");
				group.printPersons();
			}
		} else {
			System.out.println("No groups are generated");
		}
	}
	
}
