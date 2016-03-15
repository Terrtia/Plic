package plic.arbre;

import plic.VariablesGlobales;
import plic.arbre.expression.Expression;

public class Condition extends ArbreAbstrait {
	private Expression condition;
	private BlocDInstructions alors;
	private BlocDInstructions sinon;
	
	public Condition(Expression condition,BlocDInstructions alors,BlocDInstructions sinon){
		this.condition = condition;
		this.alors = alors;
		this.sinon = sinon;
	}
	
	public String toMips() {
		VariablesGlobales.getInstance().addSi();
		int nbSi = VariablesGlobales.getInstance().getSi();
		StringBuilder sb = new StringBuilder();
		sb.append("si"+nbSi+" :		"+condition.toMips()+"\n");
		sb.append("beqz $v0,sinon"+nbSi+"\n");
		sb.append("alors"+nbSi+" :	"+alors.toMips()+"\n");
		sb.append("b finsi"+nbSi+"\n");
		sb.append("sinon"+nbSi+" : 	  "+sinon.toMips()+"\n");
		sb.append("finsi"+nbSi+":\n");
		return null;
	}

}
