package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box.Filler;

import org.w3c.dom.ls.LSInput;

import com.google.gson.*;

public class Arquivo {

	public static final Arquivo instance = new Arquivo();

	private Arquivo() {

	}

	public static Arquivo getInstance() {
		return instance;
	}

	public void gravarDados(ArrayList<? extends Entidade> listaPersistir, String path) throws IOException {

		Gson gson = new Gson();
		if (path.equals("Cliente")) {
			path = "Clientes.txt";
		}
		if (path.equals("Produto")) {
			path = "Produtos.txt";
		}
		if(path.equals("Venda")) {
			path = "Venda.txt";
		}
		FileWriter arquivo;
		arquivo = new FileWriter(path);

		BufferedWriter escrever = new BufferedWriter(arquivo);
		if (!listaPersistir.isEmpty()) {
			for (int i = 0; i < listaPersistir.size(); i++) {

				listaPersistir.get(i).setPersistido(true);
				escrever.write(gson.toJson(listaPersistir.get(i)));
				escrever.newLine();

			}
		} else {
			escrever.close();
			arquivo.close();
		}
		escrever.close();
		arquivo.close();

	}

	public ArrayList<? extends Entidade> lerDados(String type) throws IOException {

		String path = null;
		Gson gson = new Gson();
		if (type.equals("Cliente")) {
			ArrayList<Cliente> listaRecuperar = new ArrayList<Cliente>();
			path = "Clientes.txt";
			FileReader arq = new FileReader(path);
			BufferedReader bf = new BufferedReader(arq);
			while (bf.ready()) {
				String linha = bf.readLine();
				Cliente cliente = gson.fromJson(linha, Cliente.class);
				listaRecuperar.add(cliente);
			}
			arq.close();
			return listaRecuperar;

		}
		if (type.equals("Produto")) {
			ArrayList<Produto> listaRecuperar = new ArrayList<Produto>();
			path = "Produtos.txt";
			FileReader arq = new FileReader(path);
			BufferedReader bf = new BufferedReader(arq);
			while (bf.ready()) {
				String linha = bf.readLine();
				Produto produto = gson.fromJson(linha, Produto.class);
				listaRecuperar.add(produto);
			}
			arq.close();
			return listaRecuperar;
		}
		
		if (type.equals("Venda")) {
			ArrayList<Venda> listaRecuperar = new ArrayList<Venda>();
			path = "Venda.txt";
			FileReader arq = new FileReader(path);
			BufferedReader bf = new BufferedReader(arq);
			while (bf.ready()) {
				String linha = bf.readLine();
				Venda venda = gson.fromJson(linha, Venda.class);
				listaRecuperar.add(venda);
			}
			arq.close();
			return listaRecuperar;
		}
		return null;

	}

}
