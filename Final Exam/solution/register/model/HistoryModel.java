package register.model;

import java.util.Stack;

public class HistoryModel {

	private static final HistoryModel INSTANCE = new HistoryModel();
	
	private Stack<IndexedEntry> history;

	private HistoryModel() {
		history = new Stack<>();
	}

	public static HistoryModel getInstance() {
		return INSTANCE;
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
}