package plic.tds;

import java.util.ArrayList;

import plic.VariablesGlobales;
import plic.tds.entrees.Entree;
import plic.tds.symboles.Symbole;

public class TDS {

	private static TDS instance = new TDS();
	
	private ArrayList<DictLocal> ldico;
	private DictLocal dico;
	private boolean analyseSemantique;
	
	private TDS() {
		ldico = new ArrayList<DictLocal>();
		//dico = new DictLocal(null, 0); plic 1
	}
	
	public static TDS getInstance() {
		return instance;
	}
	
	public int getTailleZoneVar() {
		return dico.getDeplacement();
	}
	
	public void setAnalyseSemantique() {
		this.analyseSemantique = true;
	}
	
	public void ajouter(Entree e, Symbole s) {
		dico.ajouter(e, s);
		//System.out.println(toString());
	}
	
	public Symbole identifier(Entree e) {
		return dico.identifier(e);
	}
	
	public void entrerBloc() {
		if(!this.analyseSemantique){
			VariablesGlobales.getInstance().IncrNumeroBloc(); //Bloc ++
			dico = new DictLocal(dico, VariablesGlobales.getInstance().getNumeroBloc());
			ldico.add(dico);
		} else {    //analyse Semantique
			
		}
	}
	
	public void sortirBloc() {
		
		if(!this.analyseSemantique){
			dico = dico.getParent();
			//!\\ Zone Memoire
		} else {    //analyse Semantique
			dico = dico.getParent();
		}
	}

	@Override
	public String toString() {
		return "TDS [ldico=" + ldico.toString() + ", dico=" + dico
				+ ", analyseSemantique=" + analyseSemantique + "]";
	}
	
}
