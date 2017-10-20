package edu.homework06.animals.multicellular.fish;

import edu.homework06.animals.eat.EatFish;

public class Salmon extends Fish implements EatFish{
	
	@Override
	public String getName() {
		return "Salmon";
	}
	
}
