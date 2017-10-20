package edu.homework06.animals.move;

public interface MoveSwim extends Move {

	@Override
	default void move() {
		System.out.println(this.getName() + " swims.");
	}
	
}
