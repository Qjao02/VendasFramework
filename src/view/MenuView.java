package view;

import FrameworkMIF.*;

public class MenuView {

	public static void mostrar() {

		Menu menu = new Menu();

		Menu menuCliente = new Menu();
		menuCliente.setTitle("Menu Cliente");
		menu.getActionList().add(menuCliente);
		menu.run();
	}
}
