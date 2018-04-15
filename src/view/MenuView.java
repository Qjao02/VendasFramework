package view;

import java.util.ArrayList;
import java.util.Scanner;

import FrameworkMIF.*;
import controller.ClienteController;
import model.Cliente;



public class MenuView {
	
	public static ArrayList<Cliente> clientes;
	public static ClienteController clienteController;
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
		menu.getActionList().add(menuVenda);
		
		menu.run();
	}
}
