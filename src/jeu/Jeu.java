package jeu;

import narrateur.Narrateur;

public class Jeu {

    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurEnCours;
    private Plateau plateau;
    private Narrateur narrateur;
    private int tour = 1;

    public Jeu(Joueur joueur1, Joueur joueur2, Plateau plateau, Narrateur narrateur) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.plateau = plateau;
        this.narrateur = narrateur;
        this.joueurEnCours = joueur2; 
    }

    public void jouer() {
        System.out.println(narrateur.annonceDebutJeu(joueur1, joueur2));

        while (!finJeu()) {

            changerJoueur();

            System.out.println(narrateur.annonceDebutTour(joueurEnCours, tour));
            tour++;
            
            int resultatDes = joueurEnCours.lancerDes(plateau);
            if (joueurEnCours.getEffet() == JoueurEffet.IVRE)
            {
            	resultatDes = -resultatDes;
            }
            else if (joueurEnCours.getEffet() == JoueurEffet.PACTE)
            {
            	resultatDes += joueurEnCours.lancerDeUnique(plateau);
            }
            System.out.println(narrateur.annonceLancementDes(joueurEnCours, resultatDes));

            System.out.println(narrateur.annonceDeplacement(joueurEnCours));

            joueurEnCours.deplacerPion(resultatDes);

            Case caseArrivee = plateau.getCase(joueurEnCours.getPion().getPosition() - 1);
            if (caseArrivee != null) {
                System.out.println(narrateur.annonceArriverCase(joueurEnCours, caseArrivee));
            }
        }

        System.out.println(narrateur.annonceGagnant(getGagnant()));
    }

    private void changerJoueur() {
        if (joueurEnCours == joueur1) joueurEnCours = joueur2;
        else joueurEnCours = joueur1;
    }

    private boolean finJeu() {
        return getGagnant() != null;
    }

    public Joueur getGagnant() {
        if (!joueur1.estVivant()) return joueur2;
        if (!joueur2.estVivant()) return joueur1;

        int derniereCase = plateau.getNombreCases(); // 30
        if (joueur1.getPion().getPosition() >= derniereCase) return joueur1;
        if (joueur2.getPion().getPosition() >= derniereCase) return joueur2;

        return null;
    }
}
