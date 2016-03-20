package plic.tds;

import java.util.HashMap;

import plic.exceptions.DoubleDeclarationException;
import plic.exceptions.EntreeNonDeclareeException;
import plic.tds.entrees.Entree;
import plic.tds.symboles.Symbole;

public class DictLocal {
	
	private HashMap<Entree, Symbole> dico;
	
	private DictLocal parent;
	private int numeroBloc;
	private int deplacement;
	
	public DictLocal(DictLocal p, int bloc) {
		dico = new HashMap<Entree, Symbole>();
		parent = p;
		numeroBloc = bloc;
		deplacement = 0;
	}

	public DictLocal getParent() {
		return parent;
	}
	
	public int getNumeroBloc() {
		return numeroBloc;
	}
	
	public int getDeplacement() {
		return deplacement;
	}

	public void ajouter(Entree e, Symbole s) {
		if(dico.containsKey(e)){
			throw new DoubleDeclarationException(e.getIdf());
		} else {
			s.setDeplacement(deplacement);
			dico.put(e, s);	
			deplacement += 4; 
		}
		
	}
	
	public Symbole identifier(Entree e) {
		for(Entree m : dico.keySet()) {
			if(m.equals(e))
				return dico.get(m);
		}
		if(dico.containsKey(e)) {	// containsKey ne fait pas l'égalité entre la nouvelle entrée e et celle du dico
			return dico.get(e);
		}else if(!dico.containsKey(e) && numeroBloc == 0) {
			throw new EntreeNonDeclareeException(e.getIdf());
		}else {
			return getParent().identifier(e);
		}
	}

	@Override
	public String toString() {
		return "DictLocal [dico=" + dico.toString() + ", parent=" + parent
				+ ", numeroBloc=" + numeroBloc + "]";
	}
	
	
}
