package plic.arbre.expression;

import plic.exceptions.AnalyseSyntaxiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {
	
	private boolean estEntier;

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite);
        this.estEntier = false;
    }  
    
    public StringBuilder toMipsBinaireArithmetique() {
    	StringBuilder s = new StringBuilder();
    	System.out.print(gauche.estEntier());
    	System.out.print(droite.estEntier());
    	System.out.print("\n");
    	System.out.print(gauche.verify());
    	System.out.print(droite.verify());
    	System.out.print("\n");
    	System.out.print("\n");
    	
    	if(!this.verify()) {
    		if(gauche.estBoolean()){
    			throw new AnalyseSyntaxiqueException("ligne 1, Left Operand found: boolean, expected: Integer\n");
    		} else if(droite.estBoolean()) {
    			throw new AnalyseSyntaxiqueException("ligne 1, Right Operand found: booleean, expected: Integer\n");
    		} else {
    			throw new AnalyseSyntaxiqueException("ligne 1, ERROR 0x54A551E54\n");
    		}
    
    	}
    	s.append(this.gauche.toMips());
    	s.append(this.droite.toMips());
    	return s;
    }
    
}
