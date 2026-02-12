package jeu;

public class Pion {
	private CouleurPion couleur;
	private Case position;
	
	public enum CouleurPion{
		Rouge,
		Bleu
	}
	
	public Pion(CouleurPion couleur, Plateau plateau)
	{
		this.couleur = couleur;
		position = plateau.getCase(0);
	}
	
	public Case getCase()
	{
		return position;
	}
	
	public void setPosition(Case nouvellePosition)
	{
		position = nouvellePosition;
	}
	
	public String getCouleur()
	{
		return couleur.toString();
	}
}
