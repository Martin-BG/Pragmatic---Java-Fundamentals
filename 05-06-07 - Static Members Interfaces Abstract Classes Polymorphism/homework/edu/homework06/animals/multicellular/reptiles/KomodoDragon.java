package edu.homework06.animals.multicellular.reptiles;

import edu.homework06.animals.eat.EatAnimals;
import edu.homework06.animals.move.MoveWalk;

public class KomodoDragon extends Reptile implements MoveWalk, EatAnimals{

	@Override
	public String getName() {
		return "Komodo dragon";
	}

	@Override
	public void move() {
		MoveWalk.super.move();
	}

}
