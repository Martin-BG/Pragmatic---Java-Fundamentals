package register.model;

import java.util.Stack;

public class History {

	private Stack<IndexedEntry> history;

	public History() {
		history = new Stack<>();
	}

	public void push(Entry entry, int index) {
		history.push(new IndexedEntry(entry, index));
	}

	public IndexedEntry pop() {
		return history.pop();
	}

	public boolean isEmpty() {
		return history.isEmpty();
	}

	public void clear() {
		history.clear();
	}
}