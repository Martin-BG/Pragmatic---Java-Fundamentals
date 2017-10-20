package edu.homework06.animals.move;

public interface MoveFly extends Move {

	@Override
	default void move() {
		System.out.println(this.getName() + " flies.");
	}
	
}
