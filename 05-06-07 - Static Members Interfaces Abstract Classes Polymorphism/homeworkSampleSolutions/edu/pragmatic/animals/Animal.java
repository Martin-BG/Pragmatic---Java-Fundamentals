package edu.pragmatic.animals;

public abstract class Animal {
	
	private int age;
	
	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}
	}
	
	public int getAge() {
		return this.age;
	}
	
	public abstract void eat(Animal otherAnimal);
	public abstract void walk();
	
}
