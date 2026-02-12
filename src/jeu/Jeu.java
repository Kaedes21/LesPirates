package jeu;

public class Jeu {
	
	private Joueur joueur1;
	private Joueur joueur2;
	
	public Jeu(Joueur joueur1,Joueur joueur2)
	{
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	public void commencerJeu()
	{
		
	}
	
	public void debutTour(Joueur joueur)
	{
		
	}
	
	public boolean verifierFinJeu()
	{
		return !(joueur1.getPion().getPosition() == 30 || joueur2.getPion().getPosition() ==30);
	}
}
