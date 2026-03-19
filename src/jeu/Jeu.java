package jeu;

import jeu.pirates.Pirate;
import jeu.pirates.pions.CouleurPion;
import jeu.plateau.Plateau;
import jeu.plateau.cases.Case;
import jounaldebord.Narrateur;

public class Jeu {

    private final Pirate pirate1;
    private final Pirate pirate2;
    private Pirate pirateEnCours;
    private final Plateau plateau;
    private final Narrateur narrateur;
    private final De de1 = new De(6);
    private final De de2 = new De(6);
    private int tour = 1;

    public Jeu(Narrateur narrateur) {
        this.narrateur = narrateur;
        this.plateau = new Plateau(); 
        
        this.pirate1 = new Pirate(narrateur.demanderNomPirate(1), CouleurPion.BLEU);
        this.pirate2 = new Pirate(narrateur.demanderNomPirate(2), CouleurPion.ROUGE);
    }

    public void jouer() {
        Case caseArrivee;
        System.out.println(narrateur.annoncerDebutJeu(pirate1, pirate2));

        while (!finJeu()) {
            narrateur.attendreEntree();

            changerJoueur();

            System.out.println(narrateur.annoncerDebutTour(pirateEnCours, tour++));

            int resultatDes = lancerDes(pirateEnCours);

            System.out.println(narrateur.annoncerLancementDes(resultatDes));

            deplacerPirate(pirateEnCours, resultatDes);

            caseArrivee = plateau.getCase(pirateEnCours.getPion().getPosition() - 1);
            
            caseArrivee.appliqueEffet(pirateEnCours);

            System.out.println(narrateur.annoncerArriverCase(pirateEnCours, caseArrivee));            
        }
        
        if (!pirate1.estVivant()) {
            System.out.println(narrateur.annoncerKO(pirate1));
        }
        else if (!pirate2.estVivant()) {
            System.out.println(narrateur.annoncerKO(pirate2));
        }
        System.out.println(narrateur.annoncerGagnant(getGagnant()));
        narrateur.fermer();
    }

    private int lancerDes(Pirate pirate) {
        int scoreInitial = de1.lancerDe() + de2.lancerDe();
        return pirate.getEffet().calculerDeplacement(scoreInitial, de1);
    }

    private void deplacerPirate(Pirate pirate, int deplacement) {
        int position = pirate.getPion().getPosition();
        int derniereCase = plateau.getNombreCases();
        position += deplacement;
        
        while (position > derniereCase) {
            position = derniereCase - (position - derniereCase);
        }
        
        if (position < 1) position = 1;
        pirate.deplacerPion(position);
    }

    private void changerJoueur() {
        if (pirateEnCours == pirate1) {
            pirateEnCours = pirate2;
        } else {
            pirateEnCours = pirate1;
        }
    }

    private boolean finJeu() {
        return getGagnant() != null;
    }

    private Pirate getGagnant() {
        if (!pirate1.estVivant()) {
            return pirate2;
        }
        if (!pirate2.estVivant()) {
            return pirate1;
        }
        int derniereCase = plateau.getNombreCases();
        if (pirate1.getPion().getPosition() >= derniereCase) return pirate1;
        if (pirate2.getPion().getPosition() >= derniereCase) return pirate2;
        return null;
    }
}