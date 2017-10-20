package edu.pragmatic05;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		System.out.println(ShapesHelpers.PI);
		System.out.println(ShapesHelpers.A);
		//ShapesHelpers.pi = 40;
		
		System.out.println("Enter radius: ");
		Scanner sc = new Scanner(System.in);
		double radius = sc.nextDouble();
		
		//ShapesHelpers sh = new ShapesHelpers();
		//double area = sh.getCircleArea(radius);
		double area = ShapesHelpers.getCircleArea(radius);
		
		System.out.println("Area is: " + area);
		
		System.out.println(ShapesHelpers.getCircleArea(34));
		
		
		
	}
}
