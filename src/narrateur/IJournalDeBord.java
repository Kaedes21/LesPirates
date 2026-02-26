package narrateur;


import cases.Case;
import pirates.Pirate;

public interface IJournalDeBord {
	public String annoncerDebutJeu(Pirate joueur1,Pirate joueur2);
	public String annoncerDebutTour(Pirate joueur, int tour);
	public String annoncerGagnant(Pirate joueur);
	public String annoncerLancementDes(Pirate joueur,int valeur);
	public String annoncerDeplacement(Pirate joueur);
	public String annoncerArriverCase(Pirate joueur,Case caseArrive);
	public String annoncerKO(Pirate pirate);
}
