package edu.homework05.groups;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GroupsGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Number of students: ");
		int studentsCount = Integer.parseInt(scanner.nextLine());

		System.out.print("Desired number of students per group: ");
		int studentsPerGroup = Integer.parseInt(scanner.nextLine());

		List<String> students = new ArrayList<>();

		for (int i = 1; i <= studentsCount; i++) {
			System.out.printf("Student %d: ", i);
			students.add(scanner.nextLine());
		}

		Collections.shuffle(students);

		int currentGroup = 1;
		int studentsInCurrentGroup = 0;
		int remainder = students.size() % 2;

		for (int i = 0; i < students.size() - remainder; i++) {
			if (studentsInCurrentGroup == 0) {
				System.out.printf("%nGroup %d:", currentGroup);
			}

			System.out.printf(" %s;", students.get(i));

			studentsInCurrentGroup++;

			if (studentsInCurrentGroup >= studentsPerGroup) {
				currentGroup++;
				studentsInCurrentGroup = 0;
			}
		}

		if (remainder == 1) {
			System.out.printf(" %s;", students.get(students.size() - 1));
		}

		scanner.close();
	}
}