package view;

import java.util.ArrayList;

import FrameworkMIF.Method;

public class CadastrarCliente implements Method {

	@Override
	public void run() {
		ArrayList<String> dadosEntrada = new ArrayList<String>();
		
		System.out.println("Nome do cliente: ");
		String nome = MenuView.in.nextLine();
		
		System.out.println("Endereço do cliente: ");
		String endereco = MenuView.in.nextLine();
		
		System.out.println("RG do cliente: ");
		String rg = MenuView.in.nextLine();
		
		System.out.println("Data de nascimento do cliente (dd/MM/YYYY): ");
		String data = MenuView.in.nextLine();
		
		dadosEntrada.add(nome);
		dadosEntrada.add(endereco);
		dadosEntrada.add(rg);
		dadosEntrada.add(data);
<<<<<<< HEAD
		String msg = MenuView.clienteController.create(dadosEntrada, MenuView.clientes);
		System.out.println(msg);
		
=======
>>>>>>> 246dfab4df91062b943121139b68787fd902ce5f
		MenuView.clienteController.create(dadosEntrada, MenuView.clientes);
	}
	
	

}
