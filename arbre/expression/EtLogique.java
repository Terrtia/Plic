package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class EtLogique extends BinaireLogique {

    public EtLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }

    public String toMips() {
		StringBuilder sb = new StringBuilder();
		if(this.verify()){
			sb.append(gauche.toMips());
			sb.append(droite.toMips());
			//operation et
			//sb.append();
		}else{
			System.err.println("Exected the same type");
		}
		return sb.toString();
	}
    
    public boolean verify(){
    	return gauche.estBoolean() && droite.estBoolean() && droite.verify() && gauche.verify();
    }
	

}
