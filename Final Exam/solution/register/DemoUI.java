package register;

import register.controller.RegisterFrame;
import register.model.History;
import register.model.Register;
import register.model.RegisterManager;
import register.persistance.PersistanceManager;

public class DemoUI {

	public static void main(String[] args) {
		RegisterManager registerController = new RegisterManager(PersistanceManager.getInstance(), new History(), new Register(null));
		RegisterFrame frame = new RegisterFrame(registerController);
		frame.setVisible(true);
	}
}