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
		sb.append("li $v0, " + this.cste + "\n");
		sb.append("sw $v0, ($sp)\n");
		sb.append("addi $sp, $sp, -4\n");
		sb.append("\n");
		return sb.toString();
	}
	

}
