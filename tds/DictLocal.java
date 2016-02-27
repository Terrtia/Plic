package plic.tds;

import java.util.HashMap;

import plic.exceptions.DoubleDeclarationException;
import plic.tds.entrees.Entree;
import plic.tds.symboles.Symbole;

public class DictLocal {
	
	private HashMap<Entree, Symbole> dico;
	
	private DictLocal parent;
	private int numeroBloc;
	
	public DictLocal(DictLocal p, int bloc) {
		dico = new HashMap<Entree, Symbole>();
		parent = p;
		numeroBloc = bloc;
	}

	public DictLocal getParent() {
		return parent;
	}
	
	public int getNumeroBloc() {
		return numeroBloc;
	}

	public void ajouter(Entree e, Symbole s) {
		if(dico.containsKey(e)){
			throw new DoubleDeclarationException("");
		} else {
			dico.put(e, s);	
		}
		
	}
	
	
}
