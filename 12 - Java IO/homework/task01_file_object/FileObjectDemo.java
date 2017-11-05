package task01_file_object;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileObjectDemo {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			
			System.out.print("File to open (default: res/a.txt): ");
			String path = reader.readLine().trim();
			if (path == null || path.isEmpty()) {
				path = "res/a.txt";
			}
			
			try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(path))) {
				System.out.println(path + " found and open");
			} catch (FileNotFoundException e) {
				System.out.println(path + " not found!");
			} finally {
				System.out.println("\"finally\" - closes open resources (if any)");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}