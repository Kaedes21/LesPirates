package main;

import jeu.Jeu;
import jeu.Joueur;
import jeu.Pion.CouleurPion;
import jeu.Plateau;
import narrateur.Narrateur;

public class Main {
	public static void main(String[] args)
	{
		
		Plateau plateau = new Plateau();
		Joueur joueur1 = new Joueur("Pirate1",CouleurPion.Bleu,plateau);
		Joueur joueur2 = new Joueur("Pirate2",CouleurPion.Rouge,plateau);
		Narrateur narrateur = new Narrateur("Narrateur"); 
		
		Jeu jeu = new Jeu(joueur1,joueur2, plateau);
		jeu.commencerJeu();
		System.out.println(narrateur.annonceDebutJeu(joueur1, joueur2));
		
		joueur1.deplacerPion(6);
		System.out.println(narrateur.annonceDeplacement(joueur1.getPion(),6));
		System.out.println(narrateur.annonceArriverCase(joueur1.getPion(), joueur1.getPion().getCase()));
		
		joueur1.deplacerPion(3);
		System.out.println(narrateur.annonceDeplacement(joueur1.getPion(),3));
		System.out.println(narrateur.annonceArriverCase(joueur1.getPion(), joueur1.getPion().getCase()));
	}
}
