package edu.homework06.animals.unicellular;

import edu.homework06.animals.Animal;

public abstract class Unicellular extends Animal {

	public void grow() {
		System.out.println(this.getName() + " grows");
	}

}
