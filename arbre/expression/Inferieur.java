package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Inferieur extends Comparaison {

    public Inferieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " < ";
    }

    public String toMips() {
		StringBuilder sb = new StringBuilder();
		sb.append("# Inferieur\n");
		if(this.verify()){
			sb.append(gauche.toMips());
			sb.append(droite.toMips());
			//operation <
			//sb.append();
		}else{
			System.err.println("Exected the same type");
		}
		return sb.toString();
	}
    
    public boolean verify(){
    	return gauche.estEntier() && droite.estEntier() && droite.verify() && gauche.verify();
    }
    
}
