package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Constante extends Expression {

    protected String cste ;
    
    protected Constante(String texte) {
        cste = texte ;
    }

    public boolean estConstante(){
    	return true;
    }
    
    @Override
    public String toString() {
        return cste ;
    }

  
}
