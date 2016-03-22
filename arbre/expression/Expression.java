package plic.arbre.expression;

import plic.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
    protected String type;
	
    protected Expression(int ligne) {
        super(ligne) ;
    }
    
    public String getType(){
    	return type;
    }
    	
    protected boolean estConstante() {
    	return false;
    }
    
    public boolean estBoolean() {
    	return false;
    }
    
    public boolean estEntier(){
    	return false;
    }
    
    protected boolean est0(){
    	return false;
    }
    
    public abstract boolean verify();

}
