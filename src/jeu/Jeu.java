package jeu;

import java.util.Scanner;
import cases.Case;
import jounaldebord.Narrateur;
import pirates.Pirate;
import pirates.pions.CouleurPion;

public class Jeu {

    private final Pirate pirate1;
    private final Pirate pirate2;
    private Pirate pirateEnCours;
    private final Plateau plateau;
    private final Narrateur narrateur;
    private final De de1 = new De(6);
    private final De de2 = new De(6);
    private int tour = 1;

    public Jeu(Pirate pirate1, Pirate pirate2, Plateau plateau, Narrateur narrateur) {
        this.pirate1 = pirate1;
        this.pirate2 = pirate2;
        this.plateau = plateau;
        this.narrateur = narrateur;
        this.pirateEnCours = pirate2;
    }

    public static Pirate initialiserPirate(Scanner scanner, int numero, CouleurPion couleur) {
        System.out.println("Entrez le nom du pirate n°" + numero + " :");
        String nom = scanner.nextLine();
        return new Pirate(nom,couleur);
    }
    
    public void jouer(Scanner scanner) {
    	Case caseArrivee;
        System.out.println(narrateur.annoncerDebutJeu(pirate1, pirate2));

        while (!finJeu()) {
            System.out.println("\nAppuyez sur Entrée pour lancer le tour...");
            scanner.nextLine();

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
        }
        else {
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