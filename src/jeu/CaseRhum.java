package jeu;

public class CaseRhum extends Case {
	
	public CaseRhum(int position)
	{
		super(position);
	}
	
	@Override
	public void appliqueEffet(Joueur joueur)
	{
		joueur.gagnerCoeur(1);
		joueur.setEffet(JoueurEffet.IVRE);
	}
	
	@Override
	public String getNomCase() {
        return "Rhum";
    }
}
