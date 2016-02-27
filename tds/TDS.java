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
		
	}
	
	public static TDS getInstance() {
		return instance;
	}
	
	public void setAnalyseSemantique() {
		this.analyseSemantique = true;
	}
	
	public void ajouter(Entree e, Symbole s) {
		dico.ajouter(e, s);
	}
	
	/*public Symbole identifier(Entree e) {
		return ldico.identifier(e);
	}*/
	
	public void entrerBloc() {
		
		if(!this.analyseSemantique){
			VariablesGlobales.getInstance().IncrNumeroBloc(); //Bloc ++
			dico = new DictLocal(dico, VariablesGlobales.getInstance().getNumeroBloc());
			ldico.add(dico);
		} else {    //analyse Semantique
			
		}
	}
	
	public void sortieBloc() {
		
		if(!this.analyseSemantique){
			dico = dico.getParent();
			//!\\ ZM
		} else {    //analyse Semantique
			
		}
	}
	
}
