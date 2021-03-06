package view;

import java.util.ArrayList;

import FrameworkMIF.Method;
import model.Produto;
import model.Venda;
import controller.ProdutoController;
import controller.VendaController;

public class CadastrarVenda implements Method {

	@Override
	public void run() {
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
		
		String msg = MenuView.vendaController.create(dados, MenuView.produtos, MenuView.clientes, MenuView.vendas);
		System.out.println(msg);
	}

}
