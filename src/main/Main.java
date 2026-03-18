package main;

import jeu.Jeu;
import jounaldebord.Narrateur;

public class Main {
	
    public static void main(String[] args) {
        Narrateur narrateur = new Narrateur("Naps");
        Jeu jeu = new Jeu(narrateur);
        jeu.jouer();    
    }
}