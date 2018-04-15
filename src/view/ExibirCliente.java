package view;

import java.io.IOException;

import FrameworkMIF.Method;
import model.Cliente;

public class ExibirCliente implements Method {

	@Override
	public void run() {
		System.out.println("RG do cliente: ");
		String rg = MenuView.in.nextLine(); 
		try {
			Cliente cliente = MenuView.clienteController.retrieve(rg, MenuView.clientes);

			if (cliente != null) {
				System.out.println("Cliente recuperado: ");
				System.out.println(cliente.toString());
			} else {
				System.out.println("Cliente n�o existe.");
			}
			System.out.println("Cliente recuperado: ");
			System.out.println(cliente.toString());
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel recuperar o cliente.");
		}
	}
}
