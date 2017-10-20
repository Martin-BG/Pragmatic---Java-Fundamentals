package edu.pragmatic07;

public class Demo {

	public static void main(String[] args) {
		
		Rectangle[] rects = {
				new Rectangle(10, 4),
				new Rectangle(20, 40),
				new Rectangle(1, 3),
		};
		
		RectangleMinAreaComparator c1 = new RectangleMinAreaComparator();
		
		Rectangle minR = (Rectangle) Helper.getMinElement(rects, c1);
		System.out.println("Min area rectangle has area of: " + minR.calculateArea());
		
		RectangleMinHeightComparator c2 = new RectangleMinHeightComparator();
		Rectangle minH = (Rectangle) Helper.getMinElement(rects, c2);
		System.out.println("Min height rectangle has height of: " + minH.getHeight());
		
		
		/*
		class RectangleWidthComparator implements Comparator {
			@Override
			public int compare(Object o1, Object o2) {
				double w1 = ((Rectangle)o1).getWidth();
				double w2 = ((Rectangle)o2).getWidth();
				
				if(w1 == w2) {
					return 0;
				} else if(w1 < w2) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		RectangleWidthComparator c3 = new RectangleWidthComparator();
		Rectangle minW = (Rectangle) Helper.getMinElement(rects, c3);
		System.out.println("Min width rectangle has width of: " + minW.getWidth());
		*/
		
		Rectangle minW = (Rectangle) Helper.getMinElement(rects, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				double w1 = ((Rectangle)o1).getWidth();
				double w2 = ((Rectangle)o2).getWidth();
				
				if(w1 == w2) {
					return 0;
				} else if(w1 < w2) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		System.out.println("Min width rectangle has width of: " + minW.getWidth());
		
		/////////////
		
		// println izvikva toString() metoda na Rectangle klasa i otpechatva rezultata
		System.out.println(rects[0]);
	}
}









