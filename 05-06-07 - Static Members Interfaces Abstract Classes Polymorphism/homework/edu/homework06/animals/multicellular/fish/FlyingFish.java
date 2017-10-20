package edu.homework06.animals.multicellular.fish;

import edu.homework06.animals.eat.EatPlants;
import edu.homework06.animals.move.MoveFly;

public class FlyingFish extends Fish implements MoveFly, EatPlants{

	@Override
	public String getName() {
		return "Flying Fish";
	}

	@Override
	public void move() {
		MoveFly.super.move();
	}

}
