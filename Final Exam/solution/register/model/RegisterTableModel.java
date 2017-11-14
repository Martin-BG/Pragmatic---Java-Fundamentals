package register.model;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import register.model.Entry;

@SuppressWarnings("serial")
public class RegisterTableModel extends AbstractTableModel {

	private List<Entry> entries;

	public RegisterTableModel(Collection<Entry> entries) {
		super();
		this.setEntries(entries);
	}

	public void setEntries(Collection<Entry> entries) {
		this.entries = new ArrayList<Entry>(entries);
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return (entries != null ? entries.size() : 0);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Entry entry = entries.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entry.getDate();
		case 1:
			return entry.getColor();
		case 2:
			return entry.getBreed();
		case 3:
			return entry.getSex();
		case 4:
			return entry.getState();
		case 5:
			return entry.getName();
		case 6:
			return entry.getDateCreated();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Date";
		case 1:
			return "Color";
		case 2:
			return "Breed";
		case 3:
			return "Sex";
		case 4:
			return "State";
		case 5:
			return "Name";
		case 6:
			return "Date Created";
		default:
			return null;
		}
	}
}