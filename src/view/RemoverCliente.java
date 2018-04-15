package view;

import java.io.IOException;

import FrameworkMIF.Method;

public class RemoverCliente implements Method {

	@Override
	public void run() {
		System.out.println("Digite o RG do cliente: ");
		String rg = MenuView.in.nextLine();
		
		try {
			String msg = MenuView.clienteController.delete(rg, MenuView.clientes);
			System.out.println(msg);

			MenuView.clienteController.delete(rg, MenuView.clientes);
		} catch (IOException e) {
			System.out.println("Nao foi possivel persistir/recurperar os dados.");
		}
	}

}
