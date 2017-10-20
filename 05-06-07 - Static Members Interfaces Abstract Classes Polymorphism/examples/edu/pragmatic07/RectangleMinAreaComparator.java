package edu.pragmatic07;

public class RectangleMinAreaComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		double area1 = ((Rectangle)o1).calculateArea();
		double area2 = ((Rectangle)o2).calculateArea();
		
		if(area1 == area2) {
			return 0;
		} else if(area1 < area2) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
