package edu.pragmatic07;

/**
 * Tova e interfeis za comparator, koito da se izpolzva pri sravniavane mejdu obekti
 * @author pragmatic
 *
 */
public interface Comparator {

	/**
	 * 
	 * @param o1
	 * @param o2
	 * @return 0 if o1 = o2, -1 if o1 < o2, 1 if o1 > o2
	 */
	int compare(Object o1, Object o2);
}
