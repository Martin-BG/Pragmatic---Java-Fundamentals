package edu.pragmatic.animals;

public class Slipper extends Unicelluar {

	@Override
	public void grow() {
		System.out.println("Slipper grow");
	}

	@Override
	public void eat(Animal otherAnimal) {
		System.out.println("Slipper eat");
	}

	@Override
	public void walk() {
		System.out.println("Slipper walk");
	}

}
