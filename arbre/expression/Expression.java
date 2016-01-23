package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
    
    protected Expression() {
        super() ;
    }
    
    protected boolean estConstante() {
    	return false;
    }
    
    protected boolean estBoolean() {
    	return false;
    }

}
