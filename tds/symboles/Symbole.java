package plic.tds.symboles;

public abstract class Symbole {

	protected String type;
	protected String statut;
	protected int dep;
	
	@Override
	public String toString() {
		return "Symbole [type=" + type + ", statut=" + statut + ", dep=" + dep
				+ "]";
	}
	
	/*public Symbole(String t, String s, int d) {
		type = t;
		statut = s;
		dep = d;
	}*/
	
}
