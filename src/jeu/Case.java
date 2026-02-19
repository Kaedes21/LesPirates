package jeu;

public class Case {
	
	private int position;
	
	public Case(int position)
	{
		this.position = position;
	}
	
	public void appliqueEffet(Joueur joueur)
	{
		joueur.setEffet(JoueurEffet.NORMAL);
	}
	
	public String getNomCase() {
        return "Normale";
    }
}
