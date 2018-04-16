package view;

import java.io.IOException;

import FrameworkMIF.Method;

public class RemoverProduto implements Method {

	@Override
	public void run() {
		System.out.println("Digite o codigo do produto ");
		String codigo = MenuView.in.nextLine();
		
		try {
			MenuView.produtoController.delete(codigo, MenuView.produtos);
		} catch (IOException e) {
			System.out.println("Nao foi possivel persistir/recurperar os dados.");
		}
	}

}
