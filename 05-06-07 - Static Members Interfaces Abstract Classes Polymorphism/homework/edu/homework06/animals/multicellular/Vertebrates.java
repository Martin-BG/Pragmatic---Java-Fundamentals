package edu.homework06.animals.multicellular;

public abstract class Vertebrates extends Multicellular {

	public void interact(Vertebrates other) {
		if (this.getClass() == other.getClass()) {
			System.out.println(this.getName() + " interacts with another " + other.getName() + ".");
		} else {
			System.out.println(this.getName() + " cannot interact with " + other.getName() + ".");
		}
	}

}
