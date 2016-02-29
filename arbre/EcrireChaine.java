package plic.arbre;
import plic.VariablesGlobales;
import plic.arbre.expression.Expression;
import plic.tds.TDS;

public class EcrireChaine {
	private TDS tds;
	private String message ;
		
	public EcrireChaine(String mess){
		message = mess;
		VariablesGlobales.getInstance().addData(mess);
	}
		
	public String toMips(){
		StringBuilder sb = new StringBuilder();
		sb.append("la $a0 \n");
		sb.append("li $v0, 4\n");
		sb.append("syscall\n");
		return sb.toString();
	}
}

