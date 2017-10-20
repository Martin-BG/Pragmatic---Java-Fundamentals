package edu.homework06.animals.eat;

import edu.homework06.animals.Animal;

public interface EatInsects extends Eat {

	default void eat() {
		System.out.println(this.getName() + " eats insects.");
	}
	
	default void eat(Animal animal) {
		System.out.println(this.getName() + " does not eat " + animal.getName() + ".");
	}	
	
}
