package plic.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
    protected ArbreAbstrait() {
    }
    
    public abstract void ajouter(ArbreAbstrait a);
    public abstract String toMips();
    	
}
