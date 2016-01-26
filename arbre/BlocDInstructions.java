package plic.arbre;


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

    public String entete() {
    	StringBuilder s = new StringBuilder();
    	s.append(".text\n");
    	s.append("main :\n\n");
    	return s.toString();
    }
    
    public String fin() {
    	StringBuilder s = new StringBuilder();
    	s.append("end :\n");
    	s.append("  move $v1, $v0\n");
    	s.append("  li $v0, 10\n");
    	s.append("  syscall\n");
    	return s.toString();
    }
    
    @Override
	public String toMips() {
    	/*String codeMips = "";
		for(ArbreAbstrait a: arbre) {
			codeMips = codeMips + a.toMips();
		}
		return codeMips;*/
    	return this.entete() + this.expr.toMips() + this.fin();
	}

}
