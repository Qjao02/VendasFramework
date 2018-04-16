package view;

import java.io.IOException;

import FrameworkMIF.Method;
import model.Produto;

public class ExibirProduto implements Method {

	@Override
	public void run() {
		System.out.println("RG do cliente: ");
		String rg = MenuView.in.nextLine(); 
		try {
			Produto produto = MenuView.produtoController.retrieve(rg, MenuView.produtos);
			System.out.println("Cliente recuperado: ");
			System.out.println(produto.toString());
		} catch (IOException e) {
			System.out.println("Não foi possível recuperar o cliente.");
		}
	}
}
