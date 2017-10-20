package edu.pragmatic07;

public class RectangleMinHeightComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		double h1 = ((Rectangle)o1).getHeight();
		double h2 = ((Rectangle)o2).getHeight();
		
		if(h1 == h2) {
			return 0;
		} else if(h1 < h2) {
			return -1;
		} else {
			return 1;
		}
	}
}
