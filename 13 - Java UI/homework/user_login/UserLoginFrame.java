package user_login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UserLoginFrame extends JFrame {

	private static final long serialVersionUID = -1994514317269211074L;

	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JButton loginButton;

	public UserLoginFrame() {
		super("User Login");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 150);
		setLayout(null);
		this.setResizable(false);
		
		createComponents();
	}

	private void createComponents() {	
		JLabel userNameTitleLabel = new JLabel("User name");
		userNameTitleLabel.setBounds(20, 20, 80, 30);
		add(userNameTitleLabel);

		userNameTextField = new JTextField();
		userNameTextField.setBounds(100, 20, 200, 30);
		add(userNameTextField);
		
		userNameTextField.getDocument().addDocumentListener(new DocumentActionListener());

		JLabel passwordTitleLabel = new JLabel("Password");
		passwordTitleLabel.setBounds(20, 70, 80, 30);
		add(passwordTitleLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(100, 70, 200, 30);
		add(passwordTextField);

		passwordTextField.getDocument().addDocumentListener(new DocumentActionListener());
		
		loginButton = new JButton("Login");
		loginButton.setBounds(320, 20, 150, 80);
		loginButton.setEnabled(false);
		add(loginButton);

		loginButton.getModel().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
	}

	private boolean areCredentialsValid() {
		String userName = userNameTextField.getText();
		String password = passwordTextField.getText();

		return !(userName == null || userName.isEmpty() || 
				password == null || password.isEmpty());
	}
	
	private void login() {
//		String userName = userNameTextField.getText();
//		String password = passwordTextField.getText();
//
//		if (userName == null || userName.isEmpty()) {
//			JOptionPane.showMessageDialog(this,
//					"No user name specified", 
//					"Login Error",
//					JOptionPane.ERROR_MESSAGE);
//		} else if (password == null || password.isEmpty()) {
//			JOptionPane.showMessageDialog(this,
//					"No password specified", 
//					"Login Error",
//					JOptionPane.ERROR_MESSAGE);
//		} else {
//			new LoginSuccessFrame().setVisible(true);
//			super.dispose();
//		}
		new LoginSuccessFrame().setVisible(true);
		super.dispose();
	}
	
	class DocumentActionListener implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			loginButton.setEnabled(areCredentialsValid());
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			loginButton.setEnabled(areCredentialsValid());
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			loginButton.setEnabled(areCredentialsValid());
			
		}
	}
}