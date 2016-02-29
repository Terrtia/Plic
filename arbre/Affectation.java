package plic.arbre;

import plic.arbre.expression.Expression;

public class Affectation {
	private Expression right;
	private String left;
	
	public Affectation(Expression droite,String gauche){
		right = droite;
		left = gauche;
	}
	
	public String toMips(){
		StringBuilder sb = new StringBuilder();
		sb.append(right.toMips());
		sb.append("\n");
		//a modifier avc la tds
		sb.append("sw $v0, 4(s7");
		return left;
		
	}

}
