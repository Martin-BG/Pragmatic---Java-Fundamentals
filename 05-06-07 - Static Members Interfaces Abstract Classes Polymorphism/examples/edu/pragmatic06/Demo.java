package edu.pragmatic06;

public class Demo {

	public static void main(String[] args) {
		
		//Animal a = new Animal();
		Cat c = new Cat();
		Dog d = new Dog();
		
		Animal c1 = new Cat();
		c1.makeNoise();
		c1 = new Dog();
		c1.makeNoise();
		
		System.out.println("Zoo ------");
		Zoo z = new Zoo(4);
		z.addAnimal(new Cat());
		z.addAnimal(d);
		z.addAnimal(new Dog());
		z.addAnimal(new Penguin());
		z.makeAllNoise();
		
	}
}
