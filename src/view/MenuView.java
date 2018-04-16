package view;

import java.util.ArrayList;
import java.util.Scanner;

import FrameworkMIF.Action;
import FrameworkMIF.Menu;
import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import model.Cliente;
import model.Produto;
import model.Venda;



public class MenuView {
	
	public static ArrayList<Cliente> clientes;
	public static ClienteController clienteController;
	public static ArrayList<Produto> produtos;
	public static ProdutoController produtoController;
	public static ArrayList<Venda> vendas;
	public static VendaController vendaController;
	
	public static Scanner in = new Scanner (System.in);
	
	public static void mostrar() {
		
		Menu menu = new Menu();
		clientes = new ArrayList<Cliente>();
		clienteController = new ClienteController();
		
		Menu menuCliente = new Menu();
		menuCliente.setTitle("Menu Cliente");
		menuCliente.setName("Alterar e visualizar Clientes");
		
		Action cadastrar = new Action("Cadastrar", new CadastrarCliente());
		Action remover = new Action("Remover", new RemoverCliente());
		Action modificar = new Action("Modificar", new ModificarCliente());
		Action exibir = new Action("Exibir", new ExibirCliente());
		
		menuCliente.getActionList().add(cadastrar);
		menuCliente.getActionList().add(remover);
		menuCliente.getActionList().add(modificar);
		menuCliente.getActionList().add(exibir);
		
		menu.getActionList().add(menuCliente);
		
		
		Menu menuProduto = new Menu();
		menuProduto.setTitle("Menu Produto");
		menuProduto.setName("Alterar e visualizar Produtos");
		
		
		menu.getActionList().add(menuProduto);
		
		Menu menuVenda = new Menu();
		menuVenda.setTitle("Menu Venda");
		menuVenda.setName("Alterar e visualizar Vendas");
		cadastrar = new Action("Cadastrar", new CadastrarVenda());
		remover = new Action("Remover", new RemoverVenda());
		modificar = new Action("Modificar", new ModificarVenda());
		exibir = new Action("Exibir", new ExibirVenda());
		menuVenda.getActionList().add(cadastrar);
		menuVenda.getActionList().add(remover);
		menuVenda.getActionList().add(modificar);
		menuVenda.getActionList().add(exibir);
		
		menu.getActionList().add(menuVenda);
		
		menu.run();
	}
}
