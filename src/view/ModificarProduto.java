package view;

import java.io.IOException;
import java.util.ArrayList;

import FrameworkMIF.Method;

public class ModificarProduto implements Method {

	@Override
	public void run() {
	ArrayList<String> dadosEntrada = new ArrayList<String>();
		
		System.out.println("RG do cliente: ");
		String rg = MenuView.in.nextLine();
		try {
			MenuView.produtoController.update(rg, MenuView.clientes);
			System.out.println("Nome do Produto: ");
			String nome = MenuView.in.nextLine();
			dadosEntrada.add(nome);
			System.out.println("Codigo do Produto: ");
			String codigo = MenuView.in.nextLine();
			System.out.println("Valor do Produto");
			String valor = MenuView.in.nextLine();
			dadosEntrada.add(valor);
			MenuView.produtoController.create(dadosEntrada, MenuView.produtos);
		} catch (IOException e) {
			System.out.println("Cliente não encontrado.");
		}
		
	}

}
