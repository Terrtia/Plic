package plic.arbre.blocs;

import plic.arbre.BlocDInstructions;


public class Constructeur extends Bloc {
	
	private String statut;
	private String idf;
	private int numeroBloc;
	
	private BlocDInstructions ListeDeclarations; //!\\ peut etre nulle
	private BlocDInstructions ListeDInstructions;

	public Constructeur(String statut, String idf, int numeroBloc, BlocDInstructions ListeDeclarations, BlocDInstructions ListeDInstructions) {
		this.statut = statut;
		this.idf = idf;
		this.numeroBloc = numeroBloc;
		this.ListeDeclarations = ListeDeclarations;
		this.ListeDInstructions = ListeDInstructions;
		
	}
	
	public String getStatut() {
		return statut;
	}
	
	public String getIdf() {
		return idf;
	}
	
	public int getNumeroBloc() {
		return numeroBloc;
	}

	public String toMips() {
		return null;
	}

	public String toString() {
		return null;
	}

}
