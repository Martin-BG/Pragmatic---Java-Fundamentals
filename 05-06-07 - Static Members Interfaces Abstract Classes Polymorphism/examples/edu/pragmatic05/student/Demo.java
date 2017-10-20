package edu.pragmatic05.student;

public class Demo {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.age = 10;
		s1.name = "Pesho";
		s1.goToSchool();
		
		
		CoolStudent cs1 = new CoolStudent();
		cs1.age = 20;
		cs1.name = "Gosho";
		cs1.haircutStyle = "pricheska";
		cs1.goToSchool();
				
		// s2 e ot tip Student i moje da sochi kym obekti, koito sa studenti. CoolStudent e student zaradi inheritance-a i
		// sledovatelno s2 moje da sochi obket ot tip CoolStudent
		Student s2 = new CoolStudent();
		// Izvikva se goToSchool() na CoolStudent, zashtoto s2 sochi CoolStudent
		s2.goToSchool();		
		s2 = new Student();
		// Izvikva se goToSchool() na Student, zashtoto s2 sochi Student
		s2.goToSchool();		
		s2 = new RichStudent();
		// Izvikva se goToSchool() na RichStudent, zashtoto s2 sochi RichStudent
		s2.goToSchool();
		
		Student s3 = new Student();
		s3.age = 10;
		s3.name = "Gosho 2";
		// instanceof proveriava dali s3 sochi kum obekt ot tip CoolStudent
		if(s3 instanceof CoolStudent) {
			// Karame kompilatora da gleda na s3 vse edno e ot tip CoolStudent i da kompilira .isMyCarClean
			((CoolStudent) s3).isMyCarClean = true;
		}
		
		Student s4 = new CoolStudent();
		((CoolStudent)s4).goToDisco();
		
		CoolStudent s5 = new CoolStudent();
		s5.goToDisco();
		
		//s5 = s4;
		//CoolStudent s6 = new Student();
		//s6.haircutStyle = "dd";
		
		CoolStudent cs2 = new RichStudent();
		
		// Object e bazov klas za vsichki klasove
		Object o = new CoolStudent();
		o = new Student();
		o = new String();
	}
}
