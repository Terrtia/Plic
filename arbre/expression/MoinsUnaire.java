package plic.arbre.expression;

import plic.exceptions.AnalyseSyntaxiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	public String toMips() {
		StringBuilder s = toMipsUnaire();
		if(!verify())
			throw new AnalyseSyntaxiqueException("entier requis apres l'operateur unaire - \n");
		s.append("# MoinsUnaire\n");
		s.append("add $sp, $sp, 4\n");
		s.append("lw $v0, ($sp)\n");
		
		s.append("move $t8, $v0\n"); // t8 = v0
		s.append("sub $v0, $v0, $t8\n"); // v0 = v0 - t8*2
		s.append("sub $v0, $v0, $t8\n"); 
		
		s.append("sw $v0, ($sp)\n");
		s.append("addi $sp, $sp, -4\n");
		return s.toString();
	}

	@Override
	public boolean verify() {
		return expression.estEntier();
	}

}
