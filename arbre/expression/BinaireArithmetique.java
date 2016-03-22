package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite,int ligne) {
        super(gauche, droite,ligne);
        type = "entier";
    }  
    
    public boolean estEntier() {
    	return true;
    }
    
    public StringBuilder toMipsBinaireArithmetique() {
    	StringBuilder s = new StringBuilder();
    	
    	if(!this.verify()) {
    		if(gauche.estBoolean()){
    			throw new AnalyseSemantiqueException("ligne 1, Operation: " + this.operateur() + ", Operande gauche, trouve: Booleen, attendu: Entier\n");
    		} else if(droite.estBoolean()) {
    			throw new AnalyseSemantiqueException("ligne 1, Operation: " + this.operateur() + ", Operande droite, trouve: Booleen, attendu: Entier\n");
    		} else {
    			throw new AnalyseSemantiqueException("ligne 1, division par 0 impossible\n");
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
