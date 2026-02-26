package main;

import jeu.Jeu;
import jeu.Plateau;
import narrateur.Narrateur;
import pirates.Pirate;
import pirates.CouleurPion;

public class Main {

    public static void main(String[] args) {

        Plateau plateau = new Plateau();
        Pirate joueur1 = new Pirate("Pirate1", CouleurPion.BLEU);
        Pirate joueur2 = new Pirate("Pirate2", CouleurPion.ROUGE);
        Narrateur narrateur = new Narrateur("La Mouette");

        Jeu jeu = new Jeu(joueur1, joueur2, plateau, narrateur);
        jeu.jouer();
    }
}
