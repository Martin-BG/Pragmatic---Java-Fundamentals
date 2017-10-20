package edu.homework06.animals.move;

import edu.homework06.animals.AnimalInterface;

public interface Move extends AnimalInterface{

	default void move() {
		System.out.println(this.getName() + " moves.");
	}
}
