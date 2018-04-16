package view;

import java.util.ArrayList;

import FrameworkMIF.Method;

public class CadastrarProduto implements Method {

	@Override
	public void run() {
		ArrayList<String> dadosEntrada = new ArrayList<String>();
		
		System.out.println("Nome do Produto: ");
		String nome = MenuView.in.nextLine();
		
		System.out.println("Digite o codigo do Produto: ");
		String codigo = MenuView.in.nextLine();
		
		System.out.println("Digite o valor do Produto: ");
		String valor = MenuView.in.nextLine();
		
		
		dadosEntrada.add(nome);
		dadosEntrada.add(codigo);
		dadosEntrada.add(valor);
		MenuView.produtoController.create(dadosEntrada, MenuView.produtos);
	}
	
	

}
