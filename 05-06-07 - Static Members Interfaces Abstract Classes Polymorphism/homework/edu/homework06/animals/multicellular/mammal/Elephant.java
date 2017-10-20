package edu.homework06.animals.multicellular.mammal;

import edu.homework06.animals.eat.EatPlants;

public class Elephant extends Mammal implements EatPlants{

	@Override
	public String getName() {
		return "Elephant";
	}

}
