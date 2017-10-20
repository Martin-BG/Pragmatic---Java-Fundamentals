package edu.pragmatic07;

public class Helper {

	/**
	 * Tozi metod vryshta minimalen element ot spisyk (masiv) s elementi
	 * @param elements masiv s elementi, izmejdu koito se tyrsi
	 * @param pomoshtnik comparator, koito se izpolzva
	 * @return null, ako ne nameri element ili referencia, ako nameri
	 * @see Comparator
	 */
	public static Object getMinElement(Object[] elements, Comparator pomoshtnik) {
		if(elements == null || elements.length == 0) {
			return null;
		}
		
		Object min = elements[0];
		for(int i = 1; i < elements.length; i++) {
			if(pomoshtnik.compare(elements[i], min) == -1) {
				min = elements[i];
			}
		}
		
		return min;
	}	
}
