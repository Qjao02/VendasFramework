package model;

public abstract class Entidade {
	
	private boolean persistido = false;
	
	
	
	public boolean isPersistido() {
		return persistido;
	}

	public void setPersistido(boolean persistido) {
		this.persistido = persistido;
	}

	public abstract String toString();
	
	
	
}
