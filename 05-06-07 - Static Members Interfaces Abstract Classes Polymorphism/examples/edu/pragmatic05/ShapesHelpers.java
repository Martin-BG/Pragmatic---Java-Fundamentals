package edu.pragmatic05;



public class ShapesHelpers {

	//private static double pi = 3.14;
	static final double PI = 3.14;
	
	static final double PI_2;
	
	static final double A = getCircleArea(10);
	
	static {
		boolean isFriday = true;
		if(isFriday) {
			PI_2 = 10;
		} else {
			PI_2 = 3;
		}
	}
	
	static double getCircleArea(double radius) {
		//f();
		g();
		return PI * radius * radius;
	}
	
	static void g() {
		System.out.println("g");
	}
	
//	static double getPi() {
//		return pi;
//	}
	
	void f() {		
		System.out.println(PI);
		System.out.println(getCircleArea(10));
	}
}
