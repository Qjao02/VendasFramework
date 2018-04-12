package model;

import com.google.gson.Gson;

public class ItemVenda extends Entidade implements Totalizavel {

	Produto produto;
	float valor;
	int quantidade;
	
	

	/**
	 * @param produto
	 * @param valor
	 * @param quantidade
	 */
	public ItemVenda(Produto produto, float valor, int quantidade) {
		super();
		this.produto = produto;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	@Override
	public float total() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		String string = gson.toJson(this);
		return string;
	}


}
