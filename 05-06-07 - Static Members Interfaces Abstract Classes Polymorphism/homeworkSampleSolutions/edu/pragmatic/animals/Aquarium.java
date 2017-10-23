package edu.pragmatic.animals;

public class Aquarium {
	
	private Swimable[] animals;
	
	Aquarium(int maxAnimalsCount) {
		animals = new Swimable[maxAnimalsCount];
	}
	
	public void addAnimal(Swimable a) {
		for(int i = 0; i < animals.length; i++) {
			if(animals[i] == null) {
				animals[i] = a;
				return;
			}
		}
		
		System.out.println("No more space in the aquarium");
	}
	
	public void swimAll() {
		for(Swimable a : animals) {
			if(a != null) {
				a.swim();
			}
		}
	}
	
}
