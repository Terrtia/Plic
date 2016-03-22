package plic.arbre;

import plic.VariablesGlobales;
import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;
import plic.tds.symboles.SymboleVar;

public class Declaration extends ArbreAbstrait {
	
	public Declaration(String nom, String type, String statut,int ligne) {
		super(ligne);
		TDS.getInstance().ajouter(new EntreeVar(nom), new SymboleVar(statut, VariablesGlobales.getInstance().getNumeroBloc(), type, -1/*deplacement*/));
	}
	
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public String toString() {
		return "Declaration []";
	}

}
