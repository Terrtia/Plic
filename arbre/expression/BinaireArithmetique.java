package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    

    public String toMips() {
    	StringBuilder s = new StringBuilder();
    	
    	//Left Expression
    	if(this.gauche.estConstante()) {
    		s.append(this.gauche.toMips());
    		
    		//Right Expression
    		if(this.droite.estConstante()) {
    			s.append(this.droite.toMips());
    		} else if(this.droite.estBoolean()) {
    			System.err.println("Expected: integer, found: boolean");
    		} else {
    			s.append(this.droite.toMips());
    		}
    		
    	} else if(this.gauche.estBoolean()) {
    		System.err.println("Expected: integer, found: boolean");
    	} else {
    		s.append(this.gauche.toMips());
    	}
    	
    	return s.toString();
    }
    
}
