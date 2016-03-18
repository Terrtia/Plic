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
		
		sb.append("\nsi" + nbSi + " :		\n\n" + condition.toMips() );
		sb.append("beqz $v0,sinon" + nbSi + "\n\n");
		sb.append("alors" + nbSi + " :	\n\n" + alors.toMips() );
		sb.append("b finsi" + nbSi + "\n\n");
		sb.append("sinon" + nbSi + " : 	  \n\n" + sinon.toMips() );
		sb.append("finsi" + nbSi + ":\n\n");
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Condition [condition=" + condition + ", alors=" + alors
				+ ", sinon=" + sinon + "]";
	}

}
