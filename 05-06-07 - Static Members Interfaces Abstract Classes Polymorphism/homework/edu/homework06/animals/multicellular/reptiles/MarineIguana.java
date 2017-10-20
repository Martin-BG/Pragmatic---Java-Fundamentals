package edu.homework06.animals.multicellular.reptiles;

import edu.homework06.animals.eat.EatPlants;
import edu.homework06.animals.move.MoveSwim;

public class MarineIguana extends Reptile implements MoveSwim, EatPlants{

	@Override
	public String getName() {
		return "Marine Iguana";
	}

	@Override
	public void move() {
		MoveSwim.super.move();
	}

}
