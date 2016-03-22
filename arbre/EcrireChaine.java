package plic.arbre;
import plic.VariablesGlobales;
import plic.tds.TDS;

public class EcrireChaine extends ArbreAbstrait {
	private TDS tds;
	private String message ;
	private int index;
		
	public EcrireChaine(String mess,int ligne){
		super(ligne);
		message = mess;
		VariablesGlobales.getInstance().addData(mess);
	}
		
	public String toMips(){
		StringBuilder sb = new StringBuilder();
		sb.append("la $a0 str"+index+" \n");
		sb.append("li $v0, 4\n");
		sb.append("syscall\n");
		return sb.toString();
	}

	
	
	@Override
	public String toString() {
		return "EcrireChaine [tds=" + tds + ", message=" + message + ", index="
				+ index + "]";
	}
}

