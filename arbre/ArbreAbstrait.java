package plic.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    private int ligne;
    protected ArbreAbstrait(int nbLigne) {
    	ligne = nbLigne;
    }
    
    public abstract String toMips();
    
    public abstract String toString();

	public boolean verify() {
		// TODO Auto-generated method stub
		return true;
	}
    	
}
