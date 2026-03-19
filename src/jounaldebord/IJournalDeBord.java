package jounaldebord;

import jeu.pirates.Pirate;
import jeu.plateau.cases.Case;

public interface IJournalDeBord {
	
	public void attendreEntree();
    public String demanderNomPirate(int numero);
    public String annoncerDebutJeu(Pirate joueur1, Pirate joueur2);
    public String annoncerDebutTour(Pirate joueur, int tour);
    public String annoncerGagnant(Pirate joueur);
    public String annoncerLancementDes(int valeur);
    public String annoncerDeplacement(Pirate joueur);
    public String annoncerArriverCase(Pirate joueur, Case caseArrive);
    public String annoncerKO(Pirate pirate);
    public void fermer(); 
}