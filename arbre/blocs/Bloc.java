package plic.arbre.blocs;

import plic.arbre.ArbreAbstrait;

public abstract class Bloc extends ArbreAbstrait {

	protected Bloc(int nbLigne) {
		super(nbLigne);
	}
	
	public StringBuilder EntrerBlocToMips(int numeroBloc) {

		StringBuilder s = new StringBuilder();
		
		s.append("# nouveau bloc : \n");
		s.append("# allocation valeur de retour\n");
		s.append("addi $sp, $sp, -4\n");
		s.append("# adresse de retour\n");
		s.append("sw $ra, ($sp)\n");
		s.append("addi $sp, $sp, -4\n");
		s.append("# empiler s7, chaînage dynamique\n");
		s.append("sw $s7, ($sp)\n");
		s.append("addi $sp, $sp, -4\n");
		s.append("# numéro bloc\n");
		s.append("li $v0, " + numeroBloc + "\n");
		s.append("sw $v0, ($sp)\n");
		s.append("addi $sp, $sp, -4\n");
		s.append("# fin entete bloc\n");
		s.append("\n");
		
		return s;
	}
	
	public StringBuilder SortirBlocToMips() {
		StringBuilder s = new StringBuilder();
		
		s.append("# sortie du bloc : \n");
		s.append("#restaurer le pointeur de pile\n");
		s.append("addi $sp, $s7, 16\n");
		s.append("#restaurer la base locale s7\n");
		s.append("lw $s7, 8($s7)\n");
		s.append("#charger l'adresse de retour dans le compteur ordinal\n");
		s.append("lw $ra, ($sp)\n");
		s.append("jr $ra\n");
		s.append("#fin du bloc\n");
		s.append("\n");
		
		return s;
	}

}
