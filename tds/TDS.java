package plic.tds;

import java.util.ArrayList;

import plic.VariablesGlobales;
import plic.tds.entrees.Entree;
import plic.tds.symboles.Symbole;
import plic.tds.symboles.SymboleConstructeur;

public class TDS {

	private static TDS instance = new TDS();
	
	private ArrayList<DictLocal> ldico;
	private DictLocal dico;
	private boolean analyseSemantique;
	
	private DictLocal constructeur;
	
	private TDS() {
		ldico = new ArrayList<DictLocal>();
		constructeur = new DictLocal(null, -1);
		
		int numeroBloc = VariablesGlobales.getInstance().getNumeroBloc();
		dico = new DictLocal(null, numeroBloc);
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
	
	public void ajouterConstructeur(Entree e, SymboleConstructeur s) {
		constructeur.ajouter(e, s);
	}
	
	public Symbole identifierConstructeur(Entree e) {
		return constructeur.identifier(e);
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
