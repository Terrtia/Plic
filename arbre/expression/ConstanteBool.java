package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte) {
        super(texte) ;
    }

    protected boolean estBoolean() {
    	return true;
    }
    
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		if(this.cste.equals("vrai"))
			sb.append("li $v0, 1\n");
		else
			sb.append("li $v0, 0\n");
		sb.append("sw $v0, ($sp)\n");
		sb.append("addi $sp, $sp, -4\n");
		sb.append("\n");
		return sb.toString();
	}
	

}
