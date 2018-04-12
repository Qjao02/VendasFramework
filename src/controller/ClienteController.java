package controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import FrameworkMIF.Method;
import model.Arquivo;
import model.Cliente;
import model.Entidade;

public class ClienteController {

	
	public String getClassName() {
		return "Cliente";
	}

	
	public String create(ArrayList<String> generic, ArrayList<? extends Entidade> lista) {
		Cliente cliente;
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) lista;
		ArrayList<String> dados = generic;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = sdf.parse(dados.get(3));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			cliente = new Cliente(dados.get(0), dados.get(1), dados.get(2), date);
		} catch (Exception e) {
			return "Cliente não pode ser criado";
		}

		clientes.add(cliente);
		for(Cliente cliente2 : clientes)
			System.out.println(cliente2.toString());
	
		return "Cliente " + cliente.getNome() + "cadastrado com sucesso";

	}

	public void save(ArrayList generic) {
		ArrayList<Cliente> listSave = generic;
		Arquivo arquivo = Arquivo.getInstance();
		try {
			arquivo.gravarDados(listSave, this.getClassName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public String delete(String id, ArrayList<? extends Entidade> lista) throws IOException {
		String message = "impossivel remover o cliente";
		ArrayList<Cliente> listaPersistir = new ArrayList<Cliente>();
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) lista;

		for (Cliente cliente : listaPersistir)
			cliente.setPersistido(false);

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getRg().equals(id)) {
				clientes.remove(i);
				message = "removido com sucesso";
			}
		}
		for (Cliente cliente : listaPersistir)
			System.out.println(cliente.toString());

		return message;
	}

	
	public String update(String id, ArrayList<? extends Entidade> clientes) throws IOException {
		// TODO Auto-generated method stub

		String message = this.delete(id, clientes);

		if (message.equals("removido com sucesso"))
			return "Existe";
		else
			return "Não Existe";

	}

	
	public <T extends Entidade> T retrieve(String id, ArrayList<? extends Entidade> lista) throws IOException {
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) lista;

		for (Cliente cliente : clientes) {
			if (cliente.getRg().equals(id))
				return (T) cliente;
		}

		return null;
	}

	

}
