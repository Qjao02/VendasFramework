package view;

import java.io.IOException;

import FrameworkMIF.Method;
import model.Venda;

public class ExibirVenda implements Method {

	@Override
	public void run() {
		System.out.println("Digite o n�mero (ID) da venda: ");
		String id = MenuView.in.next();
		try {
			Venda v = MenuView.vendaController.retrieve(id, MenuView.vendas);
			if (v != null) {
				System.out.println("Venda encontrada: ");
				System.out.println(v.toString());
			} else {
				System.out.println("Venda n�o encontrada.");
			}
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel completar a opera��o!");
		}
	}

}
