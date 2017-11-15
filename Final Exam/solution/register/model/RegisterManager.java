package register.model;

import java.util.Collection;

import register.persistance.LoadingException;
import register.persistance.PersistanceManager;
import register.persistance.SavingException;

public final class RegisterManager {

	private PersistanceManager persistanceManager;
	private History history;
	private Register register;

	public RegisterManager(PersistanceManager persistanceManager, History history, Register register) {
		super();
		this.persistanceManager = persistanceManager;
		this.history = history;
		this.register = register;
	}

	public void loadData(String file) throws LoadingException {
		this.register.initEntries(persistanceManager.load(file));
		history.clear();
	}

	public void saveData(String file) throws SavingException {
		PersistanceManager.getInstance().save(getEntries(), file);
	}

	public Entry deleteEntry(int index) {
		Entry entry = register.deleteEntry(index);
		if (entry != null) {
			history.push(entry, index);
			return entry;
		}
		return null;
	}

	private void addEntry(Entry entry, int index) {
		register.addEntry(entry, index);
	}

	public boolean undoLast() {
		if (canUndo()) {
			IndexedEntry indexedEntry = history.pop();
			addEntry(indexedEntry.getEntry(), indexedEntry.getIndex());
			return true;
		}
		return false;
	}

	public boolean canUndo() {
		return !history.isEmpty();
	}

	public Collection<Entry> getEntries() {
		return register.getEntries();
	}
}