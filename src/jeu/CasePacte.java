package jeu;

public class CasePacte extends Case {
	
	public CasePacte(int position)
	{
		super(position);
	}
	
	@Override
	public void appliqueEffet(Joueur joueur)
	{
		joueur.perdreCoeur(2);
		joueur.setEffet(JoueurEffet.PACTE);
	}
	
	@Override
	public String getNomCase() {
        return "Pacte";
    }
}
