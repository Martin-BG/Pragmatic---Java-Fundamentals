package register;

import register.controller.RegisterController;
import register.model.History;
import register.model.Register;
import register.persistance.PersistanceManager;
import register.view.RegisterFrame;

public class DemoUI {

	public static void main(String[] args) {
		RegisterController registerController = new RegisterController(PersistanceManager.getInstance(), new History(), new Register(null));
		RegisterFrame frame = new RegisterFrame(registerController);
		frame.setVisible(true);
	}
}