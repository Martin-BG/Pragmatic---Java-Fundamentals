package edu.homework06.animals.eat;

import edu.homework06.animals.Animal;
import edu.homework06.animals.AnimalInterface;

public interface Eat extends AnimalInterface {

	void eat();
	
	void eat(Animal animal);
}
