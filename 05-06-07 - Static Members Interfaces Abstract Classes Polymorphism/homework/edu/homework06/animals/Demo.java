package edu.homework06.animals;

import edu.homework06.animals.multicellular.birds.*;
import edu.homework06.animals.multicellular.fish.*;
import edu.homework06.animals.multicellular.mammal.*;
import edu.homework06.animals.multicellular.reptiles.*;
import edu.homework06.animals.unicellular.*;

public class Demo {

	public static void main(String[] args) {
		Animal amoeba = new Amoeba();
		Animal paramecium = new Paramecium();
		amoeba.eat(paramecium);
		amoeba.eat(amoeba);
		
		System.out.println();
		Fish salmonA = new Salmon();
		Fish salmonB = new Salmon();	
		salmonA.interact(salmonB);
		salmonA.evolveNewCellularStructures();
		salmonA.eat(salmonB);
		Fish shark = new Shark();
		shark.move();
	    Fish flyingFish = new FlyingFish();
		flyingFish.move();
		shark.interact(flyingFish);
		shark.eat(salmonB);
		
		System.out.println();
		Reptile varan = new KomodoDragon();
		varan.move();
		Reptile cobra = new KingCobra();
		cobra.move();
		Reptile iguana = new MarineIguana();
		iguana.move();
		
		System.out.println();
		Bird penguin = new KingPenguin();
		penguin.move();
		penguin.eat(cobra);
		penguin.eat(salmonB);
		Bird eagle = new Eagle();
		eagle.move();
		Bird emu = new Emu();
		emu.move();
		
		System.out.println();
		Mammal bat = new Bat();
		bat.move();
		Mammal elephant = new Elephant();
		elephant.move();
		Mammal dolphin = new Dolphin();
		dolphin.move();
		dolphin.eat(emu);
		dolphin.eat(salmonB);
		Mammal chimp = new Chimpanzee();
		chimp.move();
		Mammal man = new Human();
		man.move();
		bat.eat();
		man.eat(bat);
		man.eat();
		bat.eat(man);
	}

}
