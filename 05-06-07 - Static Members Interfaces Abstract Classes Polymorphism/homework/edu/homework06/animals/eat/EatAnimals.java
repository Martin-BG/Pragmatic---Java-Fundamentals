package edu.homework06.animals.eat;

import edu.homework06.animals.Animal;

public interface EatAnimals extends Eat {

	default void eat() {
		System.out.println(this.getName() + " eats other animals.");
	}

	default void eat(Animal animal) {
		if (this.getClass() != animal.getClass()) {
			System.out.println(this.getName() + " eats a " + animal.getName() + ".");
		} else {
			System.out.println(this.getName() + " shall not eat another " + animal.getName() + "!");
		}
	}
}
