package register.ui;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import register.model.Entry;
import register.model.History;
import register.model.IndexedEntry;
import register.model.Register;
import register.model.RegisterTableModel;
import register.persistance.LoadingException;
import register.persistance.SavingException;

@SuppressWarnings("serial")
public class RegisterFrame extends JFrame {
	private static final String PET_ICON_FILE = "resources/pet.png";
	private static final String DEFAULT_FILE = "resources/animals.lostandfound.csv";

	private RegisterTableModel tableModel;
	private History history;
	private Register register;

	public RegisterFrame() {
		super("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLayout(null);
		setResizable(false);

		register = new Register();
		tableModel = new RegisterTableModel(register.getEntries());
		history = History.getInstance();

		createUI();
	}

	private void createUI() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 670, 375);
		add(scrollPane);
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton loadFileButton = new JButton("Load");
		loadFileButton.setBounds(10, 405, 120, 40);
		add(loadFileButton);
		
		JButton saveFileButton = new JButton("Save");
		saveFileButton.setBounds(140, 405, 120, 40);
		add(saveFileButton);
		
		JButton deleteRowButton = new JButton("Delete");
		deleteRowButton.setBounds(430, 405, 120, 40);
		add(deleteRowButton);
		deleteRowButton.setEnabled(false);

		JButton undoButton = new JButton("Undo");
		undoButton.setBounds(560, 405, 120, 40);
		add(undoButton);
		undoButton.setEnabled(false);

		try {
			BufferedImage myPicture = ImageIO.read(new File(PET_ICON_FILE));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setBounds(280, 390, 130, 75); 
			add(picLabel);
		} catch (IOException e2) {
			
		}
	
		loadFileButton.addActionListener(loadButtonAction(undoButton));
		saveFileButton.addActionListener(saveButtonAction());
		deleteRowButton.addActionListener(deleteRowButtonAction(table, deleteRowButton, undoButton));
		undoButton.addActionListener(undoButtonAction(undoButton));

		table.getSelectionModel().addListSelectionListener(e -> {
			if (table.getSelectedRow() == -1) {
				deleteRowButton.setEnabled(false);
			} else {
				deleteRowButton.setEnabled(true);
			}
		});
	}

	private ActionListener undoButtonAction(JButton undoButton) {
		return e -> {
			if (!history.isEmpty()) {
				IndexedEntry indexedEntry = history.pop();
				register.addEntry(indexedEntry.getEntry(), indexedEntry.getIndex());
				tableModel.setEntries(register.getEntries());
				undoButton.setEnabled(!history.isEmpty());
			}
		};
	}

	private ActionListener deleteRowButtonAction(JTable table, JButton deleteRowButton, JButton undoButton) {
		return e -> {
			int row = table.getSelectedRow();
			if (row != -1) {
				Entry entry = register.deleteEntry(row);
				if (entry != null) {
					history.push(entry, row);
					tableModel.setEntries(register.getEntries());
					deleteRowButton.setEnabled(false);
					undoButton.setEnabled(!history.isEmpty());
				}
			}
		};
	}
	
	private ActionListener saveButtonAction() {
		return e -> {
			JFrame parentFrame = new JFrame();
			JFileChooser fileChooser = new JFileChooser(DEFAULT_FILE);
			fileChooser.setDialogTitle("Specify a file to save");
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Values (*.csv)", "csv");
			fileChooser.addChoosableFileFilter(filter);
			
			if (fileChooser.showSaveDialog(parentFrame) == JFileChooser.APPROVE_OPTION) {
				String fileToSave = fileChooser.getSelectedFile().getAbsolutePath();
				
				if (!fileToSave.toLowerCase().endsWith(".csv")) {
					fileToSave = fileToSave + ".csv";
				}

				try {
					register.save(fileToSave);
					JOptionPane.showMessageDialog(this, 
							"Data saved to " + fileToSave, 
							"Save Success",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SavingException e1) {
					JOptionPane.showMessageDialog(this, 
							"Failed to save file: " + fileToSave,
							"Save Error", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}
	
	private ActionListener loadButtonAction(JButton undoButton) {
		return e -> {
			JFileChooser fileChooser = new JFileChooser(DEFAULT_FILE);
			fileChooser.setDialogTitle("Select file to load");
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Values (*.csv)", "csv");
			fileChooser.addChoosableFileFilter(filter);

			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				try {
					register = new Register(fileChooser.getSelectedFile().getPath());
					tableModel.setEntries(register.getEntries());
					history.clear();
					undoButton.setEnabled(!history.isEmpty());
					JOptionPane.showMessageDialog(this, 
							"Data loaded from " + fileChooser.getSelectedFile().getPath(),
							"Data Load Success", 
							JOptionPane.INFORMATION_MESSAGE);
				} catch (LoadingException e1) {
					JOptionPane.showMessageDialog(this, 
							"Invalid file: " + fileChooser.getSelectedFile().getPath(),
							"Load Error", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}
}