package edu.homework06.animals.move;

public interface MoveCrawl extends Move {

	@Override
	default void move() {
		System.out.println(this.getName() + " crawls.");
	}
	
}
