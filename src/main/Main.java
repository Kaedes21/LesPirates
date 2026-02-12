package main;

import jeu.Jeu;
import jeu.Joueur;
import jeu.Pion.CouleurPion;
import jeu.Plateau;
import narrateur.Narrateur;

public class Main {
	
	private static int resultatDes;
	public static void main(String[] args)
	{
		
		Plateau plateau = new Plateau();
		Joueur joueur1 = new Joueur("Pirate1",CouleurPion.Bleu,plateau);
		Joueur joueur2 = new Joueur("Pirate2",CouleurPion.Rouge,plateau);
		Narrateur narrateur = new Narrateur("Narrateur"); 
		
		Jeu jeu = new Jeu(joueur1,joueur2);
		jeu.commencerJeu();
		System.out.println(narrateur.annonceDebutJeu(joueur1, joueur2));
		
		
		while(jeu.verifierFinJeu()) {
			System.out.println(narrateur.annonceDebutTour(joueur2));
			resultatDes = plateau.lancerDes();
			
			joueur1.deplacerPion(resultatDes);
			System.out.println(narrateur.annonceDeplacement(joueur1.getPion(),resultatDes));
			System.out.println(narrateur.annonceArriverCase(joueur1.getPion()));
		
		}
	}
}