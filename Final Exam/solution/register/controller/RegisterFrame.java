package register.controller;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import register.model.Entry;
import register.model.RegisterManager;
import register.model.RegisterTableModel;
import register.persistance.LoadingException;
import register.persistance.SavingException;

@SuppressWarnings("serial")
public class RegisterFrame extends JFrame {
	private static final String PET_ICON_FILE = "resources/pet.png";
	private static final String DEFAULT_FILE = "resources/animals.lostandfound.csv";

	private RegisterManager registerController;
	private RegisterTableModel tableModel;
	private JButton deleteRowButton;
	private JButton undoButton;
	private JTable table;
	
	public RegisterFrame(RegisterManager registerController) {
		super("Missing Pets Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLayout(null);
		setResizable(false);

		this.registerController = registerController;
		tableModel = new RegisterTableModel(this.registerController);

		createUI();
	}

	private void createUI() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 670, 375);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton loadFileButton = new JButton("Load");
		loadFileButton.setBounds(10, 405, 120, 40);
		add(loadFileButton);
		
		JButton saveFileButton = new JButton("Save");
		saveFileButton.setBounds(140, 405, 120, 40);
		add(saveFileButton);
		
		deleteRowButton = new JButton("Delete");
		deleteRowButton.setBounds(430, 405, 120, 40);
		add(deleteRowButton);

		undoButton = new JButton("Undo");
		undoButton.setBounds(560, 405, 120, 40);
		add(undoButton);

		try {
			JLabel picLabel = new JLabel(new ImageIcon(ImageIO.read(new File(PET_ICON_FILE))));
			picLabel.setBounds(280, 390, 130, 75); 
			add(picLabel);
		} catch (IOException e) {}
	
		loadFileButton.addActionListener(e -> loadButtonAction());
		saveFileButton.addActionListener(e -> saveButtonAction());
		deleteRowButton.addActionListener(e -> deleteRowButtonAction());
		undoButton.addActionListener(e -> undoButtonAction());
		table.getSelectionModel().addListSelectionListener(e -> updateDeleteButton());
		
		updateTableAndButtonsState();
	}

	private void updateDeleteButton() {
		deleteRowButton.setEnabled(table.getSelectedRow() != -1);
	}
	
	private void updateUndoButton() {
		undoButton.setEnabled(registerController.canUndo());
	}
	
	private void updateTableAndButtonsState() {
		tableModel.update();
		updateUndoButton();
		updateDeleteButton();
	}

	private void undoButtonAction() {
		if (registerController.undoLast()) {
			updateTableAndButtonsState();
		}
	}

	private void deleteRowButtonAction() {
		int row = table.getSelectedRow();
		if (row != -1) {
			Entry entry = registerController.deleteEntry(row);
			if (entry != null) {
				updateTableAndButtonsState();
			}
		}
	}
	
	private void saveButtonAction() {
		JFileChooser fileChooser = getFileChooser("Save to File");
		
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			String fileToSave = fileChooser.getSelectedFile().getAbsolutePath();
			
			if (!fileToSave.toLowerCase().endsWith(".csv")) {
				fileToSave = fileToSave + ".csv";
			}

			try {
				registerController.saveData(fileToSave);
				JOptionPane.showMessageDialog(this, 
						"Data saved to " + fileToSave, 
						"Save Success",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (SavingException ex) {
				JOptionPane.showMessageDialog(this, 
						"Failed to save file: " + fileToSave,
						"Save Error", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void loadButtonAction() {
		JFileChooser fileChooser = getFileChooser("Load from File");

		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			String fileToLoadFrom = fileChooser.getSelectedFile().getPath();
			
			try {
				registerController.loadData(fileToLoadFrom);
				updateTableAndButtonsState();

				JOptionPane.showMessageDialog(this, 
						"Data loaded from " + fileToLoadFrom,
						"Data Load Success", 
						JOptionPane.INFORMATION_MESSAGE);
			} catch (LoadingException ex) {
				JOptionPane.showMessageDialog(this, 
						"Invalid file: " + fileToLoadFrom,
						"Load Error", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private JFileChooser getFileChooser(String dialogTitle) {
		JFileChooser fileChooser = new JFileChooser(DEFAULT_FILE);
		fileChooser.setDialogTitle(dialogTitle);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Comma Separated Values (*.csv)", "csv"));
		return fileChooser;
	}
}