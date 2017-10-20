package edu.homework06.animals.multicellular.mammal;

import edu.homework06.animals.eat.EatJunkFood;

public class Human extends Mammal implements EatJunkFood{

	@Override
	public String getName() {
		return "Human";
	}

}
