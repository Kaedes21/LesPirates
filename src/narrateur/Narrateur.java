package narrateur;

import jeu.Joueur;
import jeu.Pion;

public class Narrateur implements IJournalDeBord {
	
	private String nom;
	public Narrateur(String nom)
	{
		this.nom = nom;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	@Override
	public String annonceDebutJeu(Joueur joueur1,Joueur joueur2) {
		String texte = "Yaaaaargh! Je suis " + nom +" et c'est moi qui vais présenter la course.\n";
		texte += "Que le combat opposant " + joueur1.getNom() + " et " + joueur2.getNom() + " commence !\n";
		return texte;
	}

	@Override
	public String annonceDebutTour(Joueur joueur) {
		String texte = "Au tour de " + joueur.getNom() + " !";
		return texte;
	}

	@Override
	public String annonceGagnant(Joueur joueur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String annonceDeplacement(Pion pion, int valeur) {
		String texte = "Le pion " + pion.getCouleur() + " avance de " + valeur; 
		return texte;
	}

	@Override
	public String annonceArriverCase(Pion pion) {
		String texte = "Le pion " + pion.getCouleur() + " est maintenant sur la case " + pion.getPosition(); 
		texte += "\n";
		return texte;
	}

	@Override
	public String annonceEffetCase(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String annonceCoeursPerdus(Joueur joueur, int nbCoeurs) {
		// TODO Auto-generated method stub
		return null;
	}

}
