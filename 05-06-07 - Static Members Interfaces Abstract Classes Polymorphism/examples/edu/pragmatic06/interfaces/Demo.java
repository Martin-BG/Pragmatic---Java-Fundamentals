package edu.pragmatic06.interfaces;

public class Demo {

	public static void main(String[] args) {
		
		MemoryStorage m;
		//m = new MemoryStorage();
		m = new CD();
		m.save("file");
		m.delete("file");
		m = new USB();
		m.save("file");
		
	}
}
