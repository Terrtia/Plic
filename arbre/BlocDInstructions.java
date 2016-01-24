package plic.arbre;

import java.util.ArrayList;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
	//protected ArrayList<ArbreAbstrait> arbre;
    protected ArbreAbstrait expr ;
    
    public BlocDInstructions() {
        super();
		//this.arbre = new ArrayList<>();
    }
    
    public void ajouter(ArbreAbstrait a) {
        expr = a ;
        //this.arbre.add(a);
    }
    
    public String toString() {
        return expr.toString() ;
    }

    @Override
	public String toMips() {
    	/*String codeMips = "";
		for(ArbreAbstrait a: arbre) {
			codeMips = codeMips + a.toMips();
		}
		return codeMips;*/
    	return this.expr.toMips();
	}

}
