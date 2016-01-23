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
    
    public String toMips(){
    	StringBuilder sb = new StringBuilder();
    	//premier cas ex : 1*2
    	if(gauche.estConstante() && droite.estConstante()){
    		
    	//deuxieme cas ex : a-8
    	}else if(!gauche.estConstante() && droite.estConstante()){
    		
    	
    	//dernier cas ex : b/a
    	}else{
    		
    	}
    	
    	return sb.toString();
    }
  
}
