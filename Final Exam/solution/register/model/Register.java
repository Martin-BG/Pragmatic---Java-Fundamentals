package register.model;

import java.util.LinkedList;
import java.util.List;

import register.persistance.SavingException;
import register.model.Entry;
import register.persistance.LoadingException;
import register.persistance.PersistanceManager;

public class Register {

	private List<Entry> entries;

	public Register() {
		super();
		entries = new LinkedList<>();
	}
	
	public Register(String file) throws LoadingException {
		super();
		load(file);
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public Entry deleteEntry(int selectedRow) {
		if (selectedRow >= 0 && selectedRow < entries.size()) {
			return entries.remove(selectedRow);
		}
		return null;
	}

	public void addEntry(Entry entry, int index) {
		if (index >= 0 && index <= entries.size()) {
			entries.add(index, entry);
		}
	}

	public void load(String file) throws LoadingException {
		entries = new LinkedList<>(PersistanceManager.getInstance().load(file));
	}

	public void save(String file) throws SavingException {
		PersistanceManager.getInstance().save(entries, file);
	}
}