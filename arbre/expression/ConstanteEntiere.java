package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte) {
        super(texte) ;
    }

    public boolean estEntier() {
    	return true;
    }
    
    public boolean est0() {
    	if(cste.equals("0"))
    		return true;
    	else
    		return false;
    }
    
	public String toMips() {
		StringBuilder s = new StringBuilder();
		s.append("li $v0, " + this.cste + "\n");
		s.append("sw $v0, ($sp)\n");
		s.append("addi $sp, $sp, -4\n");
		s.append("\n");
		return s.toString();
	}


}
