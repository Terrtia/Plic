package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Unaire extends Expression {
    
    protected Expression expression ;

    protected Unaire(Expression expr) {
        super();
        expression = expr ;
    }
    
    public abstract String operateur() ;

    public StringBuilder toMipsUnaire() {
    	StringBuilder s = new StringBuilder();
    	s.append(expression.toMips());
    	return s;
    }
    
    @Override
    public String toString() {
        return "(" + operateur() + expression + ")" ;
    }

}
