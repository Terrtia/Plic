package plic.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
    protected ArbreAbstrait() {
    }
    
    public abstract String toMips();
    
    public abstract String toString();

	public boolean verify() {
		// TODO Auto-generated method stub
		return true;
	}
    	
}
