package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte) {
        super(texte) ;
    }

    protected boolean estConstante() {
    	return true;
    }
    
	public String toMips() {
		return null;
	}

}
