package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class Venda extends Entidade implements Totalizavel {

	int numero;
	Date data;
	Cliente cliente;
	ArrayList<ItemVenda> itens;

	public Venda(int numero, Date data, Cliente cliente, ArrayList<ItemVenda> itens) {
		this.numero = numero;
		this.data = data;
		this.cliente = cliente;
		this.itens = itens;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemVenda> itens) {
		this.itens = itens;
	}

	@Override
	public float total() {
		// TODO Auto-generated method stub
		float total = 0;
		float subtotal = 0;
		for (ItemVenda itemVenda : this.itens) {
			subtotal = itemVenda.getValor() * itemVenda.getQuantidade();
			total += subtotal;
			subtotal = 0;

		}
		return total;
	}

	@Override
	public String toString() {
		String objectToString;
		String produtos = "";
		for(ItemVenda itemVenda : this.getItens()) {
			produtos  = produtos + itemVenda.getProduto().getNome() +"X " + itemVenda.getQuantidade();
		}
		objectToString = "numero: " + this.getNumero() + " data: " + this.getData() + " cliente: "
				+ this.getCliente().getNome() + "produtos: " + produtos  + " Total: " + this.total();

		return objectToString;

	}

}
