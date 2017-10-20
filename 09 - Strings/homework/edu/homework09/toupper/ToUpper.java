package edu.homework09.toupper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToUpper {

	public static void main(String[] args) {
		String text = "The code between <upcase> a special tag </upcase> is always uppercase and again <upcase> to upper case </upcase>";
		String regex = "(?<group><upcase> (?<text>.*?) <\\/upcase>)";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			text = text.replaceFirst(matcher.group("group"), matcher.group("text").toUpperCase());
		}

		System.out.println(text);
	}
}
