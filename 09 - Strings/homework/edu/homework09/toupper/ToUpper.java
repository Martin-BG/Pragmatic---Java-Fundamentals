package edu.homework09.toupper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToUpper {

	public static void main(String[] args) {
		int repeats;
		System.out.print("Number of repeats: ");
		try (Scanner scanner = new Scanner(System.in)) {
			repeats = Integer.parseInt(scanner.nextLine());
		}

		String text = "The code between <upcase> a special tag </upcase> is always uppercase and again <upcase> to upper case </upcase>";
		String regex = "(?<group><upcase> (?<text>.*?) <\\/upcase>)";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;

		// Using String
		String newText = null;
		long timer = System.nanoTime();
		for (int i = 0; i < repeats; i++) {
			newText = text;
			matcher = pattern.matcher(newText);
			while (matcher.find()) {
				newText = newText.replaceFirst(matcher.group("group"), matcher.group("text").toUpperCase());
			}
		}
		timer = System.nanoTime() - timer;
		System.out.println("[String] Elapsed time in milliseconds: " + timer / 1000000);
		System.out.println(newText);
		System.out.println();

		// Using StringBuilder
		StringBuilder sb = new StringBuilder();
		timer = System.nanoTime();
		for (int i = 0; i < repeats; i++) {
			sb = new StringBuilder(text);
			matcher = pattern.matcher(sb.toString());
			while (matcher.find()) {
				sb.replace(matcher.start(), matcher.end(), matcher.group("text").toUpperCase());
				matcher = pattern.matcher(sb.toString());
			}
		}
		timer = System.nanoTime() - timer;
		System.out.println("[StringBuilder] Elapsed time in milliseconds: " + timer / 1000000);
		System.out.println(sb);
		System.out.println();

		// Using Matcher
		timer = System.nanoTime();
		for (int i = 0; i < repeats; i++) {
			newText = text;
			matcher = pattern.matcher(newText);
			while (matcher.find()) {
				newText = matcher.replaceFirst(matcher.group("text").toUpperCase());
				matcher = pattern.matcher(newText);
			}
		}
		timer = System.nanoTime() - timer;
		System.out.println("[Matcher] Elapsed time in milliseconds: " + timer / 1000000);
		System.out.println(newText);
	}
	
}
