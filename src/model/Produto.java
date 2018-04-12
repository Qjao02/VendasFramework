package model;

import com.google.gson.Gson;

public class Produto extends Entidade {

	int codigo;
	String nome;
	float valor;

	/**
	 * @param codigo
	 * @param nome
	 * @param valor
	 */
	public Produto(int codigo, String nome, float valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		String objectToString;

		objectToString = "name: " + this.getNome() + " codigo: " + this.getCodigo() + " valor: " + this.getValor();

		return objectToString;

	}

}
