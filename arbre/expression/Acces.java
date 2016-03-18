package plic.arbre.expression;

import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;

public class Acces extends Expression {

	private String idf;
	
	public Acces(String i) {
		idf = i;
		type =  TDS.getInstance().identifier(new EntreeVar(idf)).getType();
	}
	
	public String getIdf() {
		return idf;
	}
	
	public boolean estEntier() {
		return true;
	}
	
	@Override
	public boolean verify() {
		// TODO Auto-generated method stub
		return TDS.getInstance().identifier(new EntreeVar(idf)) != null;
	}

	@Override
	public String toMips() {
		StringBuilder s = new StringBuilder();
		if(verify()) {
			s.append("# Acces variable " + idf + "\n");
			int decalage = TDS.getInstance().identifier(new EntreeVar(idf)).getDep();
			s.append("lw $v0, " + decalage + "($s7)\n");
		}
		return s.toString();
	}

	@Override
	public String toString() {
		return "Acces [idf=" + idf + "]";
	}

}
