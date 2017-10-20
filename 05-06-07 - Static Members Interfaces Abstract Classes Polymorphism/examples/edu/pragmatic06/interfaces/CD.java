package edu.pragmatic06.interfaces;

public class CD implements MemoryStorage {

	@Override
	public boolean delete(String fileName) {
		System.out.println("CD delete");
		return true;
	}

	@Override
	public boolean save(String fileName) {
		System.out.println("CD save");
		return true;
	}

}
