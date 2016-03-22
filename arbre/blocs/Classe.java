package plic.arbre.blocs;

import plic.VariablesGlobales;
import plic.arbre.BlocDInstructions;
import plic.tds.TDS;
import plic.tds.entrees.EntreeClasse;
import plic.tds.symboles.SymboleClasse;


public class Classe extends Bloc {
	
	private String idf;
	private BlocDInstructions ld;
	
	private int numeroBloc;

	public Classe(String idf, BlocDInstructions ld, int ligne) {
		super(ligne);
		this.idf = idf;
		this.ld = ld;
		this.numeroBloc = VariablesGlobales.getInstance().getNumeroBloc();

	}

	public String toMips() {
		SymboleClasse sc = (SymboleClasse) TDS.getInstance().identifier(new EntreeClasse(this.idf));
		String etiquette = sc.getEtiquette();
		
		StringBuilder s = new StringBuilder();
		
		s.append(etiquette + " : #classe " + this.idf + "\n");
		s.append(this.EntrerBlocToMips(numeroBloc));
		s.append(ld.toMips());
		s.append(this.SortirBlocToMips());
		
		
		return s.toString();
	}

	public boolean verify() {  //a faire
		return false;
	}
	
	public String toString() {
		return null;
	}

}
