package edu.homework06.animals.eat;

import edu.homework06.animals.Animal;
import edu.homework06.animals.multicellular.fish.Fish;

public interface EatFish extends Eat {

	default void eat() {
		System.out.println(this.getName() + " eats fish.");
	}
	
	default void eat(Animal animal) {
		if (animal != null && animal instanceof Fish && this.getClass() != animal.getClass()) {
			System.out.println(this.getName() + " eats a " + animal.getName() + ".");
		} else {
			System.out.println(this.getName() + " cannot eat " + animal.getName() + ".");
		}
	}
}
