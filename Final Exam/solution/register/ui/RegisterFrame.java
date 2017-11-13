package register.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import register.model.HistoryModel;
import register.model.IndexedEntry;
import register.model.Register;
import register.model.RegisterTableModel;
import register.persistance.SavingException;

@SuppressWarnings("serial")
public class RegisterFrame extends JFrame {
	static final String DEFAULT_INPUT_FILE = "resources/animals.lostandfound.csv2";

	private RegisterTableModel tableModel;
	private HistoryModel history;
	private int selectedRow;

	private Register register;

	public RegisterFrame() {
		super("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLayout(null);
		register = new Register(DEFAULT_INPUT_FILE);
		history = HistoryModel.getInstance();
		createUI();
	}

	private void createUI() {
		// Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 660, 375);
		add(scrollPane);

		JTable table = new JTable();
		scrollPane.setViewportView(table);

		tableModel = new RegisterTableModel();
		tableModel.setEntries(register.getEntries());
		table.setModel(tableModel);
		
		/////

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSelectionModel = table.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Ignore extra messages.
				if (e.getValueIsAdjusting())
					return;

				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (lsm.isSelectionEmpty()) {
					selectedRow = -1;
					// System.out.println("No rows are selected.");
				} else {
					selectedRow = lsm.getMinSelectionIndex();
					// System.out.println("Row " + selectedRow + " is now selected.");
				}
			}
		});

		/////
		JButton loadFileButton = new JButton("Load");
		loadFileButton.setBounds(10, 400, 120, 40);
		add(loadFileButton);
		loadFileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChoser = new JFileChooser("resources/animals.lostandfound.csv");
				fileChoser.setDialogTitle("Select file to load");
				fileChoser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv");
				fileChoser.addChoosableFileFilter(filter);

				int returnValue = fileChoser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChoser.getSelectedFile().getPath());

					register = new Register(fileChoser.getSelectedFile().getPath());
					tableModel.setEntries(register.getEntries());
				}
			}
		});

		JButton saveFileButton = new JButton("Save");
		saveFileButton.setBounds(140, 400, 120, 40);
		add(saveFileButton);
		saveFileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parentFrame = new JFrame();
				JFileChooser fileChooser = new JFileChooser("resources/animals.lostandfound.csv");
				fileChooser.setDialogTitle("Specify a file to save");

				int userSelection = fileChooser.showSaveDialog(parentFrame);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();

					try {
						register.save(fileToSave.getAbsolutePath());
					} catch (SavingException e1) {
						// TODO - add dialog
						System.out.println("Failed to save file: " + fileToSave.getAbsolutePath());
					}
				}
			}
		});

		JButton deleteRowButton = new JButton("Delete Selected Row");
		deleteRowButton.setBounds(270, 400, 200, 40);
		add(deleteRowButton);
		deleteRowButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedRow >= 0) {
					history.push(register.getEntry(selectedRow), selectedRow);
					register.deleteEntry(selectedRow);
					tableModel.setEntries(register.getEntries());
				}
			}
		});

		JButton undoButton = new JButton("Undo");
		undoButton.setBounds(550, 400, 120, 40);
		add(undoButton);
		undoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!history.isEmpty()) {
					IndexedEntry indexedEntry = history.pop();
					register.addEntry(indexedEntry.getEntry(), indexedEntry.getIndex());
					tableModel.setEntries(register.getEntries());
				}
			}
		});
	}
}