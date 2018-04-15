package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Entidade;

public abstract interface Controller {

	public String getClassName();


	public abstract String create(ArrayList<String> dados, ArrayList<?extends Entidade>lista);
	public abstract <T extends Entidade> T retrieve(String id, ArrayList<?extends Entidade>lista) throws IOException; 
	public abstract String delete(String id, ArrayList<?extends Entidade>lista) throws IOException;
	public abstract String update(String id, ArrayList<?extends Entidade>lista) throws IOException;



}
