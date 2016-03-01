package plic.arbre;

import plic.arbre.expression.Expression;
import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;

public class EcrireVar {
	private String var; 

	public EcrireVar(String var){
		this.var = var;
	}
	
	public String toMips(){
		StringBuilder sb = new StringBuilder();
		//int decalage = TDS.getInstance().identifier(new EntreeVar(var)).getDecalage();
		//sb.append("lw $a0, "+decalage+"(s7)\n");
		sb.append("li $v0 1\n");
		sb.append("syscall\n");
		return sb.toString();
	}

}
