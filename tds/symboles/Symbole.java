package plic.tds.symboles;

public abstract class Symbole {

	protected String statut;
	protected int numeroBloc;
	
	protected String type;
	
	protected int deplacement;
	
	public Symbole(String statut, int numeroBloc, String type, int deplacement) {
		this.statut = statut;
		this.numeroBloc = numeroBloc;
		this.type = type;
		this.deplacement = deplacement;
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
