package narrateur;

import jeu.Joueur;
import jeu.Pion;

public interface IJournalDeBord {
	public String annonceDebutJeu(Joueur joueur1,Joueur joueur2);
	public String annonceDebutTour(Joueur joueur);
	public String annonceGagnant(Joueur joueur);
	public String annonceDeplacement(Pion pion, int valeur);
	public String annonceArriverCase(Pion pion);
	public String annonceEffetCase(int position);
	public String annonceCoeursPerdus(Joueur joueur,int nbCoeurs);
}
