package edu.pragmatic06.interfaces;

public class USB implements MemoryStorage {

	@Override
	public boolean save(String fileName) {
		System.out.println("usb save");
		return true;
	}

	@Override
	public boolean delete(String fileName) {		
		System.out.println("usb delete");
		return true;
	}

	
}
