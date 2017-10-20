package edu.homework06.animals.multicellular.birds;

import edu.homework06.animals.eat.EatFish;
import edu.homework06.animals.move.MoveSwim;

public class KingPenguin extends Bird implements MoveSwim, EatFish{

	@Override
	public String getName() {
		return "King Penguin";
	}

	@Override
	public void move() {
		MoveSwim.super.move();
	}

}
