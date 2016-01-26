package plic.arbre.expression;

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
		s.append("add $sp, $sp, 4\n");
		s.append("lw $v0, ($sp)\n");
		
		s.append("li $t8, 0\n");
		s.append("blt $v0, $t8, negatif\n"); // si v0 < 0, on passe dans negatif
		// cas v0 >= 0
		s.append("move $t8, $v0\n"); // t8 = v0
		s.append("sub $v0, $v0, $t8\n"); // v0 = v0 - t8*2
		s.append("sub $v0, $v0, $t8\n"); 
		s.append("j fin\n");
		
		// cas v0 < 0
		s.append("negatif: ");
		s.append("move $t8, $v0\n"); // t8 = v0
		s.append("add $v0, $v0, $t8\n"); // v0 = v0 + 2*t8
		s.append("add $v0, $v0, $t8\n");
		
		s.append("fin: ");
		
		s.append("sw $v0, ($sp)\n");
		s.append("addi $sp, $sp, -4\n");
		return s.toString();
	}

	@Override
	public boolean verify() {
		return estEntier();
	}

}
