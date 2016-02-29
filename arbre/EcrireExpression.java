package plic.arbre;

import plic.VariablesGlobales;
import plic.arbre.expression.Expression;
import plic.tds.TDS;

public class EcrireExpression {
	private TDS tds;
	private Expression message ;
	
	public EcrireExpression(Expression mess){
		message = mess;
	}
	
	public String toMips(){
		StringBuilder sb = new StringBuilder();
		sb.append(message.toString());
		sb.append("move $a0, $v0\n");
		sb.append("li $v0 4\n");
		sb.append("syscall\n");
		return sb.toString();
	}
}
