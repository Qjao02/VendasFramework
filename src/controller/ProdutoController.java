package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.ls.LSInput;

import model.Arquivo;
import model.Cliente;
import model.Entidade;
import model.Produto;
import model.Produto;

public class ProdutoController {
	
	public String getClassName() {
		return "Produto";
	}

	
	public String create(ArrayList<String> generic, ArrayList<? extends Entidade> lista) {
		Produto produto;
		ArrayList<String> dados = generic;

		try {
			produto = new Produto(Integer.parseInt(dados.get(0)), dados.get(1), Float.parseFloat(dados.get(2)));
		} catch (Exception e) {
			return "Produto não pode ser criado";
		}

		ArrayList<Produto> listProduto = (ArrayList<Produto>) lista;
		listProduto.add(produto);
		
		return "produto" + produto.getNome() + "cadastrado com sucesso";

	}

	public void save(ArrayList<? extends Entidade> lista) {
		ArrayList<Produto> listSave = (ArrayList<Produto>)lista;
		Arquivo arquivo = Arquivo.getInstance();
		try {
			arquivo.gravarDados(listSave, this.getClassName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public <T extends Entidade> T retrieve(String id, ArrayList<? extends Entidade> lista) throws IOException {
		ArrayList<Produto> produtos = (ArrayList<Produto>) lista;
		for (Produto produto : produtos) {
			if (produto.getCodigo() == Integer.parseInt(id))
				return (T) produto;
		}

		return null;
	}

	
	public String delete(String id, ArrayList<? extends Entidade> lista) throws IOException {
		String message = "impossivel remover o cliente";
		ArrayList<Produto> produtos = (ArrayList<Produto>) lista;


		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getCodigo() == Integer.parseInt(id)) {
				produtos.remove(i);
				message = "removido com sucesso";
			}
		}
		for (Produto produto : produtos)
			System.out.println(produto.toString());

		return message;
	}

	
	public String update(String id, ArrayList<? extends Entidade> lista) throws IOException {
		// TODO Auto-generated method stub
		String message = this.delete(id, lista);

		if (message.equals("removido com sucesso"))
			return "Existe";
		else
			return "Não Existe";

	}

}
