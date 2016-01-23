package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " != ";
    }

    public String toMips() {
		StringBuilder sb = new StringBuilder();
		if(this.verify()){
			sb.append(gauche.toMips());
			sb.append(droite.toMips());
			//operation !=
			//sb.append();
		}else{
			System.err.println("Exected the same type");
		}
		return sb.toString();
	}
    
    
  
}
