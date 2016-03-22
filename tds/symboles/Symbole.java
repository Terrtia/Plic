package plic.tds.symboles;

import plic.VariablesGlobales;

public abstract class Symbole {

	protected String statut;
	protected int numeroBloc;
	
	protected String etiquette;
	protected String type;
	
	protected int deplacement;
	
	public Symbole(String statut, int numeroBloc, String type) {
		this.statut = statut;
		this.numeroBloc = numeroBloc;
		int numero = VariablesGlobales.getInstance().getEtiquette();
		this.etiquette = Integer.toString(numero);
		VariablesGlobales.getInstance().IncrEtiquette();
		this.type = type;
	}

	public String getEtiquette() {
		return etiquette;
	}
	
	public int getDeplacement() {
		return deplacement;
	}

	public String getType() {
		return type;
	}
	
	public void setDeplacement(int d) {
		deplacement = d;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setStatut(String s) {
		statut = s;
	}
	
	
}
