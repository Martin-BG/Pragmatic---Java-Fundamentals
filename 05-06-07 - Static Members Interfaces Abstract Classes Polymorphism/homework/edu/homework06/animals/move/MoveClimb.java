package edu.homework06.animals.move;

public interface MoveClimb extends Move {

	@Override
	default void move() {
		System.out.println(this.getName() + " climbs.");
	}
	
}
