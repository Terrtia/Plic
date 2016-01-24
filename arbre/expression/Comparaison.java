package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    public boolean verify(){
    	return (gauche.estBoolean() ==droite.estBoolean()) && gauche.verify() && droite.verify();
    }

    public boolean estBoolean(){
    	return true;
    }

}
