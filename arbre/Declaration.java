package plic.arbre;

import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;
import plic.tds.symboles.SymboleVar;

public class Declaration extends ArbreAbstrait {
	
	public Declaration(String n, String t, String s) {
		super();
		TDS.getInstance().ajouter(new EntreeVar(n), new SymboleVar(t, s));
	}
	
	@Override
	public String toMips() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	@Override
	public void ajouter(ArbreAbstrait a) {
		// TODO Auto-generated method stub
		
	}

}
