package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	public String toMips() {
		StringBuilder s = toMipsUnaire();
		s.append("# NonLogique\n");
		s.append("add $sp, $sp, 4\n");
		s.append("lw $v0, ($sp)\n");
		s.append("not $v0, $v0\n");
		s.append("sw $v0, ($sp)\n");
		s.append("addi $sp, $sp, -4\n");
		return s.toString();
	}

	@Override
	public boolean verify() {
		return estBoolean();
	}

}
