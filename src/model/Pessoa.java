package model;

public abstract class Pessoa extends Entidade {
	String nome;
	String endereco;

	public Pessoa(String nome, String endereco) {
		this.setNome(nome);
		this.setEndereco(endereco);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
