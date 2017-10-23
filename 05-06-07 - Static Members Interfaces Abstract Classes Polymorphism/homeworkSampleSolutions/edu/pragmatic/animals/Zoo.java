package edu.pragmatic.animals;

public class Zoo {
	
	private Animal[] animals;
	
	Zoo(int maxAnimalsCount) {
		animals = new Animal[maxAnimalsCount];
	}
	
	public void addAnimal(Animal a) {
		for(int i = 0; i < animals.length; i++) {
			if(animals[i] == null) {
				animals[i] = a;
				return;
			}
		}
		
		System.out.println("No more space");
	}
	
	public void walkAll() {
		for(Animal a : animals) {
			if(a != null) {
				a.walk();
			}
		}
	}
	
	public void pat(Person person) {
		for(Animal a : animals) {
			if(a instanceof Pattable) {
				((Pattable)a).pat(person);
			}
		}
	}
}
