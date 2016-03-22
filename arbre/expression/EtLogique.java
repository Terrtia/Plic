package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class EtLogique extends BinaireLogique {

    public EtLogique(Expression gauche, Expression droite,int ligne) {
        super(gauche, droite,ligne);
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }

    public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append("# EtLogique\n");
		if(this.verify()){
			sb.append(gauche.toMips());
			sb.append(droite.toMips());
			sb.append("add $sp, $sp, 4\n");
			sb.append("lw $t8, ($sp)\n");
			
			//Left
			sb.append("add $sp, $sp, 4\n");
			sb.append("lw $v0, ($sp)\n");
			
			sb.append("and $v0, $v0, $t8\n");
			sb.append("sw $v0, ($sp)\n");
			sb.append("addi $sp, $sp, -4\n");
			sb.append("\n");
		}else{
			throw new AnalyseSemantiqueException("ligne 1, et logique, operandes avec des types differents\n");
		}
		return sb.toString();
	}
    
    public boolean verify(){
    	return gauche.estBoolean() && droite.estBoolean() && droite.verify() && gauche.verify();
    }

}
