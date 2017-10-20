package edu.homework06.animals.multicellular.mammal;

import edu.homework06.animals.eat.EatFish;
import edu.homework06.animals.move.MoveSwim;

public class Dolphin extends Mammal implements MoveSwim, EatFish{

	@Override
	public String getName() {
		return "Dolphin";
	}

	@Override
	public void move() {
		MoveSwim.super.move();
	}

}
