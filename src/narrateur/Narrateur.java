package narrateur;

import jeu.Case;
import jeu.Joueur;
import jeu.JoueurEffet;
import jeu.Pion;

public class Narrateur implements IJournalDeBord {
	
	private String nom;
	public Narrateur(String nom)
	{
		this.nom = nom;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	@Override
	public String annonceDebutJeu(Joueur joueur1,Joueur joueur2) {
		String texte = "Yaaaaargh! Je suis " + nom +" et c'est moi qui vais présenter la course.\n";
		texte += "Que le combat opposant " + joueur1.getNom() + " et " + joueur2.getNom() + " commence !\n";
		return texte;
	}

	@Override
	public String annonceDebutTour(Joueur joueur, int tour) {
		String texte = "Nous sommes au tour "+ tour +", a " + joueur.getNom() + " ! Il lui reste " +joueur.getCoeurs()+ " coeurs.\n";
		if (joueur.getEffet() == JoueurEffet.PACTE) {
			texte += joueur.getNom() + " se prépare à faire un super lancer grace au pacte";
		}
		else if (joueur.getEffet() == JoueurEffet.IVRE) {
			texte += joueur.getNom() + " sent encore les effets du rhum de hier.";
		}
		else {
			texte += "C'est un tour normal pour " + joueur.getNom() + ".";
		}
		return texte;
	}
	
	@Override
	public String annonceGagnant(Joueur joueur) {
		String texte = "Le gagnant est " + joueur.getNom() + "!";
		return texte;
	}

	@Override
	public String annonceDeplacement(Joueur joueur) {
		String texte = "Le pion "+ joueur.getPion().getCouleur()+ " part de la case " + joueur.getPion().getPosition(); 
		return texte;
	}

	@Override
	public String annonceArriverCase(Joueur joueur,Case arrive) {
		String texte = "Le pion " + joueur.getPion().getCouleur() + " est maintenant sur la case " + joueur.getPion().getPosition() ; 
		texte += "\n";
		if ( arrive.getNomCase() == "Rhum") {
			texte += "Tiens ! " + joueur.getNom() + " trouve une bouteille de rhum, il l'a boit cul sec !\n";
			texte += "La bouteille l'a réchauffé, ce dernier récupere un coeur.\n";
		}
		if (arrive.getNomCase() == "Pacte") {
			texte += "Tiens ! " + joueur.getNom() + " croise un esprit des eaux, il conclut un marché pour améliorer son prochain tour !\n";
			texte += "Cependant, cela lui a couté 2 coeurs !\n";
		}
		return texte;
	}


	@Override
	public String annonceCoeursPerdus(Joueur joueur, int nbCoeurs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String annonceLancementDes(Joueur joueur, int valeur) {
		String texte = joueur.getNom() + " lance les dés !\nLe résultat est " + valeur + ".";
		return texte;
	}

}
