package edu.pragmatic06;

public class Zoo {

	private Animal[] animals;
	
	public Zoo(int maxAnimalsCount) {		
		animals = new Animal[maxAnimalsCount];
	}
	
	public boolean addAnimal(Animal a) {
		for(int i = 0; i < animals.length; i++) {
			if(animals[i] == null) {
				animals[i] = a;
				return true;
			}
		}
		
		return false;
	}
	
	public void makeAllNoise() {
		for(Animal a : animals) {
			if(a != null) {
				a.makeNoise();
			}
		}
	}
}
