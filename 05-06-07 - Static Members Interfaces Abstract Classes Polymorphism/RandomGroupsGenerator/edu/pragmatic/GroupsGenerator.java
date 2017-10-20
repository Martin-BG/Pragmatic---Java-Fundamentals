package edu.pragmatic;

public class GroupsGenerator {

	/**
	 * Generate groups with the provided persons. Each group has 2 persons but if the numbers
	 * of the persons is odd then the last group will have 3 persons
	 * @param persons
	 * @return Array of the generated groups or null if there are no groups generated
	 */
	static public Group[] generateGroups(Person[] persons) {
		if(persons == null || persons.length == 0) {
			return null;
		}
		
		Utils.shufflePersons(persons);
		
		int groupsCount = 0;
		if(persons.length == 1) {
			groupsCount = 1;
		} else if(persons.length % 2 == 0) {
			groupsCount = persons.length / 2; 
		} else {
			groupsCount = (persons.length - 1) / 2;
		}
		
		Group[] groups = new Group[groupsCount];
		int personIndex = 0;
		// Generate all the groups except the last one
		for(int i = 0; i < groupsCount - 1; i++) {
			int personsInGroup = 2;
			Group group = new Group(personsInGroup);
			group.addPerson(persons[personIndex]);
			personIndex++;
			group.addPerson(persons[personIndex]);
			personIndex++;
			
			groups[i] = group;
		}
		
		//Generate the last group - it contains all remaining persons from the current personIndex to the end of the persons array
		int remainingPersonsCount = (persons.length - personIndex);
		Group lastGroup = new Group(remainingPersonsCount);
		for(int i = personIndex; i < persons.length; i ++) {
			lastGroup.addPerson(persons[i]);
		}
		groups[groupsCount - 1] = lastGroup;
		
		return groups;
	}
	
}
