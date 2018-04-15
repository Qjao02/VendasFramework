package view;

import java.io.IOException;
import java.util.ArrayList;

import FrameworkMIF.Method;

public class ModificarCliente implements Method {

	@Override
	public void run() {
		
		ArrayList<String> dadosEntrada = new ArrayList<String>();
		
		System.out.println("RG do cliente: ");
		String rg = MenuView.in.nextLine();
		try {
			String msg = MenuView.clienteController.update(rg, MenuView.clientes);
			if (msg.equals("Existe")) {
				System.out.println("Nome do cliente: ");
				String nome = MenuView.in.nextLine();
				dadosEntrada.add(nome);
				System.out.println("Endereço do cliente: ");
				String endereco = MenuView.in.nextLine();
				dadosEntrada.add(endereco);
				System.out.println("Data de nascimento do cliente (dd/MM/YYYY): ");
				String data = MenuView.in.nextLine();
				dadosEntrada.add(data);
				MenuView.clienteController.create(dadosEntrada, MenuView.clientes);
			} else {
				System.out.println("Cliente não encontrado!");
			}
		} catch (IOException e) {
			System.out.println("Não foi possível persistir os dados.");
		}
	}
}
