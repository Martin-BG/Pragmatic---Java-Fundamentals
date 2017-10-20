package edu.homework06.animals.multicellular.mammal;

import edu.homework06.animals.eat.EatInsects;
import edu.homework06.animals.move.MoveFly;

public class Bat extends Mammal implements MoveFly, EatInsects{

	@Override
	public String getName() {
		return "Bat";
	}

	@Override
	public void move() {
		MoveFly.super.move();
	}

}
