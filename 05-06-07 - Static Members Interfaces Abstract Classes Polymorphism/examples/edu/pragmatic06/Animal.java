package edu.pragmatic06;

public abstract class Animal {

	private int age;
	
	public void setAge(int age) {
		if(age >= 0) {
			this.age = age;
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public void growUp() {
		setAge(age + 1);
	}
	
	abstract void makeNoise();
}
