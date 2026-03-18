package main;

import java.util.Scanner;

import jeu.Jeu;
import jeu.Plateau;
import narrateur.Narrateur;
import pirates.Pirate;
import pirates.CouleurPion;

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
