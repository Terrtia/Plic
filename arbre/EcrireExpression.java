package plic.arbre;

import plic.arbre.expression.Expression;

public class EcrireExpression extends ArbreAbstrait{
	private Expression message ;
	
	public EcrireExpression(Expression mess){
		message = mess;
	}
	
	public String toMips(){
		StringBuilder sb = new StringBuilder();
		sb.append(message.toMips());
		sb.append("move $a0, $v0\n");
		sb.append("li $v0 1\n");
		sb.append("syscall\n");
		return sb.toString();
	}

	@Override
	public String toString() {
		return "EcrireExpression [message=" + message + "]";
	}

}
