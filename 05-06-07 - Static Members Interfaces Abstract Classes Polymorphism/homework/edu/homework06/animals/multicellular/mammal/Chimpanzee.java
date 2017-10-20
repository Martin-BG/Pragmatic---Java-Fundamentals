package edu.homework06.animals.multicellular.mammal;

import edu.homework06.animals.eat.EatPlants;
import edu.homework06.animals.move.MoveClimb;

public class Chimpanzee extends Mammal implements MoveClimb, EatPlants{

	@Override
	public String getName() {
		return "Chimpanzee";
	}

	@Override
	public void move() {
		MoveClimb.super.move();
	}

}
