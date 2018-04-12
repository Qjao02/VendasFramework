package view;

import java.util.ArrayList;
import java.util.List;

import FrameworkMIF.*;
import controller.ClienteController;

public class MenuView {

	public static void mostrar() {
		List<Action> actions = new ArrayList<Action>();

		Menu menu = new Menu();

		menu.setTitle("menu inicial");
		menu.setOptionText("escolha uma opt: ");
		actions.add(new Action("sair", new MethodExit()));
		menu.setActionList(actions);
		
		Menu menuCliente = new Menu();
		menuCliente.setTitle("Menu Cliente");
		menu.getActionList().add(menuCliente);
		menu.run();

	}
}
