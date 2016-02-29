package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;
import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;
import plic.tds.symboles.SymboleVar;

public class Declaration extends ArbreAbstrait {
	
	public Declaration(String n, String t, String s) {
		super();
		TDS.getInstance().ajouter(new EntreeVar(n), new SymboleVar(t, s, 4));
	}
	
	@Override
	public String toMips() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("# Declaration\n");
		sb.append("move $s7,$sp\n");
		sb.append("addi $sp,-" + 4 + "\n\n");
		return sb.toString();
	}

}
