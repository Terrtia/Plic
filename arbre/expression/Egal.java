package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {

    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

	@Override
	public String toMips() {
		StringBuilder sb = new StringBuilder();
		if(this.verify()){
			sb.append(gauche.toMips());
			sb.append(droite.toMips());
			//operation d'egalité
			//sb.append();
		}else{
			System.err.println("Exected the same type");
		}
		return sb.toString();
	}
    
}
