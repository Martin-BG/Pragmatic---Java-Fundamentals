package edu.homework06.animals.eat;

public interface EatJunkFood extends EatAnimals {

	@Override
	default void eat() {
		System.out.println(this.getName() + " eats junk food.");
	}
	
}
