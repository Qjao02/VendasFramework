package view;

import java.io.IOException;

import FrameworkMIF.Method;

public class RemoverVenda implements Method {

	@Override
	public void run() {
		System.out.println("Digite o codigo (ID) da venda: ");
		String id = MenuView.in.next();
		
		try {
			String msg = MenuView.vendaController.delete(id, MenuView.vendas);
			System.out.println(msg);
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel persistir os dados.");
		}

	}

}
