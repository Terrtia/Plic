package plic.arbre.expression;

import plic.exceptions.AnalyseSyntaxiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {

    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append("# Egal\n");
		if(this.verify()){
			sb.append(gauche.toMips());
			sb.append(droite.toMips());
			//operation d'egalité
			sb.append("add $sp, $sp, 4\n");
			sb.append("lw $t8, ($sp)\n");
			
			//Left
			sb.append("add $sp, $sp, 4\n");
			sb.append("lw $v0, ($sp)\n");
			
			sb.append("seq $v0, $v0, $t8\n");
			sb.append("sw $v0, ($sp)\n");
			sb.append("addi $sp, $sp, -4\n");
			sb.append("\n");
		}else{
			throw new AnalyseSyntaxiqueException("ligne 1, Egal, operandes avec des types differents\n");
		}
		return sb.toString();
	}
    
}
