package plic.arbre;

import plic.arbre.expression.Expression;
import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;

public class Affectation {
	private Expression droite;
	private String gauche;
	private TDS tds;
	
	public Affectation(Expression droite,String gauche,TDS t){
		this.droite = droite;
		this.gauche = gauche;
	}
	
	public String toMips(){
		StringBuilder sb = new StringBuilder();
		sb.append(droite.toMips());
		sb.append("\n");
		//int decalage = tds.identifier(new EntreeVar(gauche));
		//sb.append("sw $v0, decalage(s7)");
		return sb.toString();	
	}
	
	public boolean verify(){
		//String type = tds.identifier(gauche).getType();
		String type = "entier";
		return droite.estEntier() == (type.equals("entier"));
	}

}
