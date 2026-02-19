package narrateur;

import jeu.Case;
import jeu.Joueur;
import jeu.Pion;

public interface IJournalDeBord {
	public String annonceDebutJeu(Joueur joueur1,Joueur joueur2);
	public String annonceDebutTour(Joueur joueur, int tour);
	public String annonceGagnant(Joueur joueur);
	public String annonceLancementDes(Joueur joueur,int valeur);
	public String annonceDeplacement(Joueur joueur);
	public String annonceArriverCase(Joueur joueur,Case arrive);
	public String annonceCoeursPerdus(Joueur joueur,int nbCoeurs);
}
