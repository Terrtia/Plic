package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

    public Mult(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
  
    @Override
    public String operateur() {
        return " * ";
    }

	@Override
	public String toMips() {
		StringBuilder s = toMipsBinaireArithmetique();
		s.append("# Mult\n");
		//Right
		s.append("add $sp, $sp, 4\n");
		s.append("lw $t8, ($sp)\n");
		
		//Left
		s.append("add $sp, $sp, 4\n");
		s.append("lw $v0, ($sp)\n");
		
		s.append("mult $v0, $t8\n");
		s.append("mflo $v0\n");
		s.append("sw $v0, ($sp)\n");
		s.append("addi $sp, $sp, -4\n");
		s.append("\n");
		return s.toString();
	}


}
