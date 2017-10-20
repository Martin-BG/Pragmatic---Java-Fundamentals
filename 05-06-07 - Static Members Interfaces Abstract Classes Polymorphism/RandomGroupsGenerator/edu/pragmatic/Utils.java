package edu.pragmatic;

import java.util.Random;

public class Utils {
	
	/**
	 * Randomly shuffle the persons in the array
	 * The algorithm for shuffle is the following (for example if the array is [p1, p2, p3, p4, p5]):
	 * 1. Find random index between 0 and endIndex = 'the last element of the array' (for example randomIndex = 2)
	 * 2. Swap the element at randomIndex with the element at the endIndex ([p1, p2, p5, p4, p3])
	 * 3. Update endIndex = endIndex - 1
	 * 4. Find random index between 0 and endIndex (for example randomIndex = 1)
	 * 5. Swap the element at randomIndex with the element at the startIndex ([p1, p4, p5, p2, p3])
	 * 6. Execute steps 3, 4 and 5 again
	 * 
	 * There is a nice explanation of the algorithm at https://www.youtube.com/watch?v=tLxBwSL3lPQ (only the explanation part, not the JavaScript code)
	 * 
	 * @param persons Array of persons to randomly shuffle
	 */
	public static void shufflePersons(Person[] persons) {
		if(persons == null || persons.length < 2) {
			return;
		}
		
		Random randomGenerator = new Random();
		
		for(int i = persons.length - 1; i > 0; i--) {
			int endIndex = i;
			int range = endIndex;
			
			int randomIndex = (randomGenerator.nextInt(range + 1));
			
			// Swap the Person at the randomIndex with the Person at the endIndex
			Person tmp = persons[endIndex];
			persons[endIndex] = persons[randomIndex];
			persons[randomIndex] = tmp;
		}
	}
	
}
