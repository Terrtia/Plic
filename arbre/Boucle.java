package plic.arbre;

import plic.VariablesGlobales;
import plic.arbre.expression.Expression;

public class Boucle extends ArbreAbstrait{
	
	private BlocDInstructions iter;
	private Expression condition;
	
	public Boucle(Expression condition,BlocDInstructions iter){
		
	}
	
	@Override
	public String toString() {
		return "Boucle [iter=" + iter + ", condition=" + condition + "]";
	}

	public String toMips() {
		VariablesGlobales.getInstance().addBoucle();
		int nbBoucle = VariablesGlobales.getInstance().getBoucle();
		StringBuilder sb = new StringBuilder();
		sb.append("tq"+nbBoucle+" : "+condition.toMips()+"\n");
		sb.append("beqz $v0,fintq"+nbBoucle+"\n");
		sb.append("iter"+nbBoucle+" : 	"+iter.toMips()+"\n");
		sb.append("jump tq"+nbBoucle+" \n");
		sb.append("fintq"+nbBoucle+" : 		\n");
		return sb.toString();
		
	}

}
