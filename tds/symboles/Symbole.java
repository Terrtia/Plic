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
	
	public void setDep(int d) {
		dep = d;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setStatut(String s) {
		statut = s;
	}

	public int getDep() {
		// TODO Auto-generated method stub
		return dep;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	/*public Symbole(String t, String s, int d) {
		type = t;
		statut = s;
		dep = d;
	}*/
	
}
