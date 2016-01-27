package plic.arbre.expression;

import plic.exceptions.AnalyseSyntaxiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }  
    
    public boolean estEntier() {
    	return true;
    }
    
    public StringBuilder toMipsBinaireArithmetique() {
    	StringBuilder s = new StringBuilder();
    	
    	if(!this.verify()) {
    		if(gauche.estBoolean()){
    			throw new AnalyseSyntaxiqueException("ligne 1, Operation: " + this.operateur() + ", Operande gauche, trouve: Booleen, attendu: Entier\n");
    		} else if(droite.estBoolean()) {
    			throw new AnalyseSyntaxiqueException("ligne 1, Operation: " + this.operateur() + ", Operande droite, trouve: Booleen, attendu: Entier\n");
    		} else {
    			throw new AnalyseSyntaxiqueException("ligne 1, ERROR 0x54A551E54\n");
    		}
    
    	}
    	s.append(this.gauche.toMips());
    	s.append(this.droite.toMips());
    	return s;
    }
    
    public boolean verify(){
    	return (gauche.estEntier() && droite.estEntier());
    }
}
