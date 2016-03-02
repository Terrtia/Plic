package plic.tds;

import java.util.HashMap;
import java.util.Map;

import plic.exceptions.DoubleDeclarationException;
import plic.exceptions.EntreeNonDeclareeException;
import plic.tds.entrees.Entree;
import plic.tds.symboles.Symbole;

public class DictLocal {
	
	private HashMap<Entree, Symbole> dico;
	
	private DictLocal parent;
	private int numeroBloc;
	private int dep;
	
	public DictLocal(DictLocal p, int bloc) {
		dico = new HashMap<Entree, Symbole>();
		parent = p;
		numeroBloc = bloc;
		dep = 0;
	}

	public DictLocal getParent() {
		return parent;
	}
	
	public int getNumeroBloc() {
		return numeroBloc;
	}
	
	public int getDep() {
		return dep;
	}

	public void ajouter(Entree e, Symbole s) {
		if(dico.containsKey(e)){
			throw new DoubleDeclarationException(e.getIdf());
		} else {
			s.setDep(dep);
			dico.put(e, s);	
			dep += 4; 
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
