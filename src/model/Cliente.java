package model;

import java.util.Date;

public class Cliente extends Pessoa {

	String rg;
	Date dataDeNascimento;

	public Cliente(String nome, String endereco, String rg, Date dataDeNascimento) {
		super(nome, endereco);
		
		this.setRg(rg);
		this.setDataDeNascimento(dataDeNascimento);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String toString() {
	
		
		String objectToString;
		
		objectToString = "name: "+ this.getNome() + " rg: "+ this.getRg() + " endereço: "+ this.getEndereco();
		
		return objectToString;
		
		
	}

	
}
