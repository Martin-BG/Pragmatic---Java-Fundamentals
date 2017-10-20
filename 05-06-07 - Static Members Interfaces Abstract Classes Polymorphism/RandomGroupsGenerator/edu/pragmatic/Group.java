package edu.pragmatic;

public class Group {

	private Person[] persons;
	
	public Group(int maxNumberOfPersons) {
		persons = new Person[maxNumberOfPersons];
	}
	
	public void addPerson(Person person) {
		for(int i = 0; i < persons.length; i++) {
			if(persons[i] == null) {
				persons[i] = person;				
				return;
			}
		}
		
		System.out.println("Cannot add person because group is full");
	}

	public void printPersons() {
		for(Person person : persons) {
			if(person != null) {
				System.out.println(person.getName());
			}
		}
	}
	
}
