package plic.arbre.expression;

import plic.exceptions.AnalyseSyntaxiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }

    public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append("# OuLogique\n");
		if(this.verify()){
			sb.append(gauche.toMips());
			sb.append(droite.toMips());
			//operation ou
			sb.append("add $sp, $sp, 4\n");
			sb.append("lw $t8, ($sp)\n");
			
			//Left
			sb.append("add $sp, $sp, 4\n");
			sb.append("lw $v0, ($sp)\n");
			
			sb.append("or $v0, $v0, $t8\n");
			sb.append("sw $v0, ($sp)\n");
			sb.append("addi $sp, $sp, -4\n");
			sb.append("\n");
		}else{
			throw new AnalyseSyntaxiqueException("ligne 1, ou logique, operandes avec des types differents\n");
		}
		return sb.toString();
	}
    
    public boolean verify(){
    	return gauche.estBoolean() && droite.estBoolean() && droite.verify() && gauche.verify();
    }

}
