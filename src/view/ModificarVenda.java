package view;

import java.io.IOException;
import java.util.ArrayList;

import FrameworkMIF.Method;
import model.Produto;

public class ModificarVenda implements Method {

	@Override
	public void run() {
		System.out.println("Digite o codigo(ID) da venda: ");
		String id = MenuView.in.next();
		try {
			String msg = MenuView.vendaController.update(id, MenuView.vendas);
			if (msg.equals("Existe")) {
				String codigo = null;
				ArrayList<String> dados = new ArrayList<String>();
				System.out.println("Digite a data da venda: ");
				dados.add(MenuView.in.nextLine());
				System.out.println("Digite o RG do cliente: ");
				dados.add(MenuView.in.nextLine());
				
				System.out.println("Selecione o  pelo codigo e digite a quantidade ou digite 's' para criar sua venda");
				for (Produto p : MenuView.produtos) {
					System.out.println(p.toString());
				}
				
				while (!codigo.equals("s")) {
					codigo = MenuView.in.next();
					dados.add(codigo);
				}
				
				msg = MenuView.vendaController.create(dados, MenuView.produtos, MenuView.clientes, MenuView.vendas);
				System.out.println(msg);
			} else {
				System.out.println("Venda não encontrada.");
			}
		} catch (IOException e) {
			System.out.println("Não foi possível recuperar os dados.");
		}
	}
}
