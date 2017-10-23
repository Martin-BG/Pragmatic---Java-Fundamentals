package edu.pragmatic.animals;

public class Amoeba extends Unicelluar {

	@Override
	public void grow() {
		System.out.println("amoeba grow");
	}

	@Override
	public void eat(Animal otherAnimal) {
		if(otherAnimal instanceof Slipper) {
			System.out.println("amoeba is eating the slipper");
		} else {
			System.out.println("amoeba cannot eat this animal");
		}
	}

	@Override
	public void walk() {
		System.out.println("amoeba walk");
	}
	
	
	
}
