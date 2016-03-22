package plic.arbre;

import plic.VariablesGlobales;
import plic.arbre.expression.Expression;

public class Condition extends ArbreAbstrait {
	private Expression condition;
	private BlocDInstructions alors;
	private BlocDInstructions sinon;
	
	public Condition(Expression condition,BlocDInstructions alors,BlocDInstructions sinon,int ligne){
		super(ligne);
		this.condition = condition;
		this.alors = alors;
		this.sinon = sinon;
	}
	

	public String toMips() {	
		
		VariablesGlobales.getInstance().addSi();
		int nbSi = VariablesGlobales.getInstance().getSi();
		StringBuilder sb = new StringBuilder();
		sb.append("\nsi" + nbSi + " :		\n\n" + condition.toMips() );
		if(sinon!=null){
			sb.append("beqz $v0,sinon" + nbSi + "\n\n");
			if(alors != null){
				sb.append("alors" + nbSi + " :	\n\n" + alors.toMips() );
				sb.append("b finsi" + nbSi + "\n\n");
			}
			sb.append("sinon" + nbSi + " : 	  \n\n" + sinon.toMips() );
		}else{
			sb.append("beqz $v0,finsi" + nbSi + "\n\n");
			if(alors != null){
				sb.append("alors" + nbSi + " :	\n\n" + alors.toMips() );
				sb.append("b finsi" + nbSi + "\n\n");
			}
		}
		sb.append("finsi" + nbSi + ":\n\n");
		return sb.toString();
	}

	public boolean verify(){
		boolean res = condition.verify() && condition.estBoolean();
		if (alors != null){
			res = res && alors.verify();
		}
		if(sinon != null){
			res = res && sinon.verify();
		}
		return res;
	}
	@Override
	public String toString() {
		return "Condition [condition=" + condition + ", alors=" + alors
				+ ", sinon=" + sinon + "]";
	}

}
