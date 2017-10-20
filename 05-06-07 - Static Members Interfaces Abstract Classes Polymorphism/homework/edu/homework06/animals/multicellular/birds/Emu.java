package edu.homework06.animals.multicellular.birds;

import edu.homework06.animals.eat.EatPlants;
import edu.homework06.animals.move.MoveRun;

public class Emu extends Bird implements MoveRun, EatPlants{

	@Override
	public String getName() {
		return "Emu";
	}

	@Override
	public void move() {
		MoveRun.super.move();
	}
	
}
