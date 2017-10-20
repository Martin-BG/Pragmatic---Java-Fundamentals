package edu.pragmatic05.student;

public class CoolStudent extends Student {

	String haircutStyle;
	boolean isMyCarClean = true;
	
	@Override
	void goToSchool() {
		if(isMyCarClean) {
			System.out.println("Otivam s kolata");
		} else {
			super.goToSchool();
		}
	}
	
	void goToDisco() {
		System.out.println("party");
	}

}
