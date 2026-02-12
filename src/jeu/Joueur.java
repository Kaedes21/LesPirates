package jeu;

import jeu.Pion.CouleurPion;

public class Joueur {
	
	private String nom;
	private int coeurs;
	private Pion pion;
	private Plateau plateau;
	
	public Joueur(String nom,CouleurPion couleur,Plateau plateau) {
		this.nom = nom;
		this.coeurs = 5;
		this.plateau = plateau;
		this.pion = new Pion(couleur,plateau);
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getCoeurs() {
		return coeurs;
	}
	
	public Pion getPion() {
		return pion;
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
	
	public void deplacerPion(int nbCases)
	{
		Case positionActuelle = pion.getCase();
		int indexActuel = positionActuelle.getNumero();
		int nouvelIndex = indexActuel + nbCases;
		
		if (nouvelIndex >= plateau.getNombreCases())
		{
			nouvelIndex = plateau.getNombreCases() - 1;
		}
		
		Case nouvelleCase = plateau.getCase(nouvelIndex);
		pion.setPosition(nouvelleCase);
	}
}
