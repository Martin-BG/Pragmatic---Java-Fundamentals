package register.model;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import register.model.Entry;

public class Register {

	private List<Entry> entries;

	public Register(Collection<Entry> entries) {
		super();
		initEntries(entries);
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

	public void initEntries(Collection<Entry> entries) {
		if (entries != null) {
			this.entries = new LinkedList<>(entries);
		} else {
			this.entries = new LinkedList<>();
		}
	}
	
	public Collection<Entry> getEntries() {
		return Collections.unmodifiableCollection(entries);
	}
}