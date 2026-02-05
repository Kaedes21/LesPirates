package jeu;

public class Joueur {
	private String nom;
	private int coeurs;
	
	public Joueur(String nom) {
		this.nom = nom;
		coeurs = 5;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getCoeurs() {
		return coeurs;
	}
	
	public void perdreCoeur(int valeur) {
		coeurs -= valeur;
		if (coeurs<0)
		{
			coeurs = 0;
		}
	}
	
	public boolean estVivant() {
		return coeurs > 0;
	}
}
