package jeu;

public class Pion {
	private CouleurPion couleur;
	private int position;
	
	public enum CouleurPion{
		Rouge,
		Bleu
	}
	
	public Pion(CouleurPion couleur, Plateau plateau)
	{
		this.couleur = couleur;
		position = 1;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public void setPosition(int nouvellePosition)
	{
		position = nouvellePosition;
	}
	
	public String getCouleur()
	{
		return couleur.toString();
	}
	
}
