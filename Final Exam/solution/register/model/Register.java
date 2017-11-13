package register.model;

import java.util.LinkedList;
import java.util.List;

import register.persistance.SavingException;
import register.model.Entry;
import register.persistance.PersistanceManager;

public class Register {

	private List<Entry> entries;

	public Register(String file) {
		super();
		load(file);
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void deleteEntry(int selectedRow) {
		if (selectedRow >= 0 && selectedRow < entries.size()) {
			entries.remove(selectedRow);
		}
	}

	public void addEntry(Entry entry, int index) {
		if (index >= 0 && index <= entries.size()) {
			entries.add(index, entry);
		}
	}

	public Entry getEntry(int index) {
		if (index >= 0 && index < entries.size()) {
			return entries.get(index);
		}
		return null;
	}
	
	public void load(String file) {
		entries = new LinkedList<>(PersistanceManager.getInstance().load(file));
	}

	public void save(String file) throws SavingException {
		PersistanceManager.getInstance().save(entries, file);
	}
}