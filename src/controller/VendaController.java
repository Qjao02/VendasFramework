package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Arquivo;
import model.Cliente;
import model.Entidade;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class VendaController{
	private static int numeroDeVendas = 1;
	
	
	
	
	
	
	public String getClassName() {
		// TODO Auto-generated method stub
		return "Venda";
	}


	
	public String create(ArrayList<String> dados, ArrayList<Produto> produtos, ArrayList<Cliente> clientes, ArrayList<Venda> vendas) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date;
		try {
			date = sdf.parse(dados.get(0));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "formato de data Invalido";
		}
		Cliente cliente;
		try{
			 cliente = new ClienteController().retrieve(dados.get(1), clientes);
		}catch (Exception e) {
			// TODO: handle exception
			return("o Cliente nao existe por favor cadastre-o");
		}
		
		ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
		for(int i = 2 ; i < dados.size() ; i = i + 2) {
			Produto produto;
			try {
			 produto = new ProdutoController().retrieve(dados.get(i),produtos);
			}catch (Exception e) {
				// TODO: handle exception
				return " o Codigo do produto nao existe por favor o cadastre";
			}
			
			ItemVenda itemVenda = new ItemVenda(produto, produto.getValor(), Integer.parseInt(dados.get(i+1)));
			itensVenda.add(itemVenda);
		}
		
		setNumeroDeVendas(this.getNumeroDeVendas()+ 1);
		Venda venda = new Venda(VendaController.getNumeroDeVendas(), date, cliente, itensVenda);
		
		vendas.add(venda);
		
		return"venda realizada com sucesso no valor de " + venda.total();
			
	}


	
	public String delete(String id, ArrayList<Venda> lista) throws IOException {
		for(Venda venda : lista ) {
			if(venda.getNumero() == Integer.parseInt(id)) {
				lista.remove(venda);
				return"removido com sucesso";
			}
		}
		return "A venda não existe";
	}

	
	public String update(String id, ArrayList<Venda> lista) throws IOException {
		
		String msg = this.delete(id,lista);
		return msg;
		
	}

	
	public <T extends Entidade> T retrieve(String id, ArrayList<Venda> lista) throws IOException {
		for(Venda venda : lista ) {
			if(venda.getNumero() == Integer.parseInt(id)) {
				return (T) venda;
			}
		}
		return null;
	
	}

	public static int getNumeroDeVendas() {
		return numeroDeVendas;
	}


	
	public static void setNumeroDeVendas(int numeroDeVendas) {
		VendaController.numeroDeVendas = numeroDeVendas;
	}
}
