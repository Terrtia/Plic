package plic ;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import plic.analyse.AnalyseurLexical;
import plic.analyse.AnalyseurSyntaxique;
import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseException;
import plic.tds.TDS;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Plic {
    
    public Plic(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            //System.err.println("expression stockée dans l'arbre : \n ---------\n" + arbre.toMips());
            
            String nom;
            nom = fichier.substring(0, fichier.length()-5);
            
            nom = nom + ".mips";
            
            FileOutputStream fos = new FileOutputStream(nom);
            String mips = data()+entete()+arbre.toMips()+fin();
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
    		sb.append("\"" + vg.getData(i) + " \" \n");
    	}
 
    	
    	return sb.toString();
    }
    
    public String entete() {
    	StringBuilder s = new StringBuilder();
    	s.append(".text\n");
    	s.append("main :\n\n");
    	s.append("# Declarations\n");
		s.append("move $s7,$sp\n");
		s.append("addi $sp,$sp,-" + TDS.getInstance().getTailleZoneVar() + "\n\n");
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
        /*if (args.length != 1) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar plic.jar <fichierSource.plic>") ;
            System.exit(1) ;
        }
        new Plic(args[0]) ;*/
    	new Plic("test1.plic");
    }
    
}
