package plic.arbre.expression;

import plic.VariablesGlobales;
import plic.tds.TDS;
import plic.tds.entrees.EntreeConstructeur;
import plic.tds.symboles.Symbole;

public class Instanciation extends Expression {
	
	private String idf;
	private Acces acces;
	private int numeroBloc;

	public Instanciation(String idf, Acces acces) {
		this.idf = idf;
		this.acces = acces;
		this.numeroBloc = VariablesGlobales.getInstance().getNumeroBloc();
	}

	public String toMips() {
		StringBuilder s = new StringBuilder();
		
		Symbole sym = TDS.getInstance().identifierConstructeur(new EntreeConstructeur(this.idf));
		String etiquette = sym.getEtiquette();
		
		s.append("#instanciation d'un objet\n");
		s.append("j " + etiquette + "\n");
		s.append("\n");
		
		return s.toString();
	}
	public boolean verify() {
		return acces.verify() && TDS.getInstance().identifierConstructeur(new EntreeConstructeur(idf)) != null;
	}
	
	public String toString() {
		return null;
	}


}
