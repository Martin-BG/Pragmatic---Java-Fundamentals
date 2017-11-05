package user_login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserLoginFrame extends JFrame {

	private static final long serialVersionUID = -1994514317269211074L;

	private JTextField userNameTextField;
	private JTextField passwordTextField;

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

		JLabel passwordTitleLabel = new JLabel("Password");
		passwordTitleLabel.setBounds(20, 70, 80, 30);
		add(passwordTitleLabel);

		passwordTextField = new JTextField();
		passwordTextField.setBounds(100, 70, 200, 30);
		add(passwordTextField);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(320, 20, 150, 80);
		add(loginButton);

		loginButton.getModel().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
	}

	private void login() {
		String userName = userNameTextField.getText();
		String password = passwordTextField.getText();

		if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
			new LoginSuccessFrame().setVisible(true);
			super.dispose();
		}
	}
}