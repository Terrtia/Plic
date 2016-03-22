package plic ;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import plic.analyse.AnalyseurLexical;
import plic.analyse.AnalyseurSyntaxique;
import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Acces;
import plic.arbre.expression.Instanciation;
import plic.exceptions.AnalyseException;
import plic.tds.TDS;
import plic.tds.entrees.EntreeVar;
import plic.tds.symboles.SymboleVar;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Plic {
	
	private Instanciation main;
    
    public Plic(String fichier, String racine) {
        try {
        	
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            //System.err.println("expression stockée dans l'arbre : \n ---------\n" + arbre.toString());
            
            /* Gestion de la classe Racine (main) */
            TDS.getInstance().ajouter(new EntreeVar("main"), new SymboleVar("publique", 0, racine));
        	this.main = new Instanciation("main", new Acces(racine, -1), -1);
        	
        	System.out.println(main.toString());
            
            String nom;
            nom = fichier.substring(0, fichier.length()-5);
            
            nom = nom + ".mips";
            
            /* Gestion de la classe Racine (main) */
            
            
            FileOutputStream fos = new FileOutputStream(nom);
            String mips = data() + entete() + arbre.toMips() + fin();
            fos.write(mips.getBytes());
            fos.close();
            
            System.out.println("COMPILATION: OK\n");
        } 
        catch (FileNotFoundException ex) {
            System.err.println("Fichier " + fichier + " inexistant") ;
        }
        catch (AnalyseException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Plic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
	public String data(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(".data\n");
    	VariablesGlobales vg = VariablesGlobales.getInstance();
    	for(int i = 0;i < vg.getDataSize();i++){
    		sb.append("str"+i+" : .asciiz ");
    		sb.append(vg.getData(i) + " \n");
    	}
 
    	
    	return sb.toString();
    }
    
    public String entete() {
    	StringBuilder s = new StringBuilder();
    	s.append(".text\n");
    	s.append("main :\n\n");
		s.append("move $s7,$sp\n");
		s.append("addi $sp,$sp,-" + TDS.getInstance().getTailleZoneVar() + "\n\n"); //inutile desormais
		
		/* Gestion de la classe Racine (main) */
    	s.append("# gestion de la classe racine\n");
		s.append(this.main.toMips());
		
    	return s.toString();
    }
    
    public String fin() {
    	StringBuilder s = new StringBuilder();
    	s.append("\nend :\n");
    	s.append("  move $v1, $v0\n");
    	s.append("  li $v0, 10\n");
    	s.append("  syscall\n");
    	return s.toString();
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar plic.jar <fichierSource.plic> <Classe racine>") ;
            System.exit(1) ;
        }
        new Plic(args[0], args[1]) ;
    }
    
}
