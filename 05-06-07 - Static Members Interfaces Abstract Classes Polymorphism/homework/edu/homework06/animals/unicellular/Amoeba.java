package edu.homework06.animals.unicellular;

import edu.homework06.animals.eat.EatUnicellular;

public class Amoeba extends Unicellular implements EatUnicellular{

	@Override
	public String getName() {
		return "Amoeba";
	}

}
