package main;

import java.util.Scanner;

import jeu.Jeu;
import jeu.Plateau;
import jounaldebord.Narrateur;
import pirates.Pirate;
import pirates.pions.CouleurPion;

public class Main {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    Plateau plateau = new Plateau();
	    
	    Pirate pirate1 = Jeu.initialiserPirate(scanner, 1, CouleurPion.BLEU);
	    Pirate pirate2 = Jeu.initialiserPirate(scanner, 2, CouleurPion.ROUGE); 
	    
	    Narrateur narrateur = new Narrateur("Naps");

	    Jeu jeu = new Jeu(pirate1, pirate2, plateau, narrateur);
	    jeu.jouer(scanner); 
	    
	    scanner.close(); 
	}
}
