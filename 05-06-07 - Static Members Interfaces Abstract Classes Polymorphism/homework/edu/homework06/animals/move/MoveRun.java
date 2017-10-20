package edu.homework06.animals.move;

public interface MoveRun extends Move {

	@Override
	default void move() {
		System.out.println(this.getName() + " runs.");
	}
	
}
